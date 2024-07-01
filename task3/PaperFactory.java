package task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaperFactory {
    private List<Person> staff = new ArrayList<>();

    public void addPerson(Person p) {
        if (p != null) {
            staff.add(p);
        }
    }

    public boolean deletePerson(Person p) {
        return staff.remove(p);
    }

    public List<Person> getStaff() {
        return new ArrayList<>(staff); // Return a copy of the staff list
    }

    public void producePaper() {
        int paperCount = staff.size();
        System.out.println("Producing " + paperCount + " papers:");
        for (int i = 0; i < paperCount; i++) {
            printPaper();
        }
    }

    private void printPaper() {
        String[] paper = {
                "---------",
                "|       |",
                "|       |",
                "---------"
        };

        for (String line : paper) {
            System.out.println(line);
        }
    }

    public void saveStaffToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(staff);
        } catch (IOException e) {
            System.err.println("Error saving staff to file: " + e.getMessage());
        }
    }

    public void loadStaffFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            staff = (List<Person>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading staff from file: " + e.getMessage());
        }
    }
}
