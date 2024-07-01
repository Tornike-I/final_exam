package task1;

import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] questionsAndAnswers = {
                {"Who was the first emperor of Rome?", "Augustus"},
                {"What year did the Roman Empire fall?", "476"},
                {"Which Roman emperor built a massive wall across Northern Britain in 122 AD?", "Hadrian"},
                {"What was the capital of the Eastern Roman Empire?", "Constantinople"},
                {"Who was the Roman god of war?", "Mars"}
        };

        int score = 0;

        System.out.println("Welcome to the Roman Empire Trivia!");
        System.out.println("Please answer the following questions:");

        for (String[] questionAndAnswer : questionsAndAnswers) {
            System.out.println(questionAndAnswer[0]);
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(questionAndAnswer[1])) {
                score++;
            }
        }

        System.out.println("You have completed the trivia!");
        System.out.println("Your score is: " + score + " out of " + questionsAndAnswers.length);

        if (score == questionsAndAnswers.length) {
            System.out.println("Excellent! You know a lot about the Roman Empire!");
        } else if (score >= questionsAndAnswers.length / 2) {
            System.out.println("Good job! You have a decent knowledge of the Roman Empire.");
        } else {
            System.out.println("You might want to read more about the Roman Empire.");
        }

        scanner.close();
    }
}

