package task3;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    String name, surname, personalNumber;

    public Person(String name, String surname, String personalNumber) {
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

        return personalNumber != null ? personalNumber.equals(person.personalNumber) : person.personalNumber == null;
    }

    @Override
    public int hashCode() {
        return personalNumber != null ? personalNumber.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                '}';
    }
}
