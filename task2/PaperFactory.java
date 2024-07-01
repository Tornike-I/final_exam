package task2;

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
}
