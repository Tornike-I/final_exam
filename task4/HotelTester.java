package task4;

public class HotelTester {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("123 Main St", "VAT123456");

        Room room1 = new Room(101, "Single");
        Room room2 = new Room(102, "Double");
        Room room3 = new Room(103, "Suite");

        // Adding rooms to the hotel
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

        // Displaying the current rooms
        System.out.println("Current rooms: " + hotel.getRooms());

        // Removing a room
        hotel.removeRoom(room2);

        // Displaying the rooms after removal
        System.out.println("Rooms after removal: " + hotel.getRooms());

        // Trying to remove a room not in the list
        boolean result = hotel.removeRoom(room2);
        System.out.println("Attempt to remove room not in list: " + result);

        // Displaying the final rooms list
        System.out.println("Final rooms: " + hotel.getRooms());

        // Saving rooms to file
        String filename = "rooms.ser";
        hotel.saveRoomsToFile(filename);
        System.out.println("Rooms saved to file.");

        // Clearing the current rooms list
        hotel = new Hotel("123 Main St", "VAT123456");
        System.out.println("Rooms after clearing: " + hotel.getRooms());

        // Loading rooms from file
        hotel.loadRoomsFromFile(filename);
        System.out.println("Rooms loaded from file: " + hotel.getRooms());
    }
}
