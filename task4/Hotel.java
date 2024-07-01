package task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements LegalEntity {
    private String address;
    private String vatNumber;
    private List<Room> rooms = new ArrayList<>();

    public Hotel(String address, String vatNumber) {
        this.address = address;
        this.vatNumber = vatNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
        }
    }

    public boolean removeRoom(Room room) {
        return rooms.remove(room);
    }

    public List<Room> getRooms() {
        return new ArrayList<>(rooms); // Return a copy of the rooms list
    }

    public void saveRoomsToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(rooms);
        } catch (IOException e) {
            System.err.println("Error saving rooms to file: " + e.getMessage());
        }
    }

    public void loadRoomsFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            rooms = (List<Room>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading rooms from file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "address='" + address + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
