package task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommunicationManager {

    private String endpoint;
    private HttpClient httpClient;
    private List<String> conversationHistory;

    public CommunicationManager(String endpoint) {
        this.endpoint = endpoint;
        this.httpClient = HttpClient.newBuilder().build();
        this.conversationHistory = new ArrayList<>();
    }

    public String sendUserMessage(String message) {
        try {
            conversationHistory.add("User: " + message);

            StringBuilder requestBodyBuilder = new StringBuilder("{");
            requestBodyBuilder.append("\"conversation_history\": [");
            for (String entry : conversationHistory) {
                requestBodyBuilder.append("\"").append(entry).append("\", ");
            }
            requestBodyBuilder.deleteCharAt(requestBodyBuilder.length() - 1);
            requestBodyBuilder.deleteCharAt(requestBodyBuilder.length() - 1);
            requestBodyBuilder.append("]}");

            String requestBody = requestBodyBuilder.toString();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(endpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {
                conversationHistory.add("Chatbot: " + response.body());
                return "Message sent successfully";
            } else {
                return "Error sending message. Response code: " + statusCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String endpoint = "https://example.com/api/endpoint"; // Here goes the real endpoint
        CommunicationManager manager = new CommunicationManager(endpoint);
        Scanner scanner = new Scanner(System.in);

        // sample conversation
        manager.sendUserMessage("Hello");
        manager.sendUserMessage("How are you?");
        manager.sendUserMessage("What's the weather like today?");

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        String result = manager.sendUserMessage(message);
        System.out.println(result);

        scanner.close();
    }
}
