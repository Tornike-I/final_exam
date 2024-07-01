package task3;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();

        Person person1 = new Person("John", "Doe", "123456");
        Person person2 = new Person("Jane", "Smith", "654321");
        Person person3 = new Person("Alice", "Johnson", "111222");

        // Adding persons to the factory staff
        factory.addPerson(person1);
        factory.addPerson(person2);
        factory.addPerson(person3);

        // Displaying the current staff
        System.out.println("Current staff: " + factory.getStaff());

        // Removing a person
        factory.deletePerson(person2);

        // Displaying the staff after removal
        System.out.println("Staff after removal: " + factory.getStaff());


        // Displaying the final staff
        System.out.println("Final staff: " + factory.getStaff());

        // Producing paper
        factory.producePaper();

        // Saving staff to file
        String filename = "staff.ser";
        factory.saveStaffToFile(filename);
        System.out.println("Staff saved to file.");

        // Clearing the current staff list
        factory = new PaperFactory();
        System.out.println("Staff after clearing: " + factory.getStaff());

        // Loading staff from file
        factory.loadStaffFromFile(filename);
        System.out.println("Staff loaded from file: " + factory.getStaff());
    }
}
