import java.util.*;

public class Person implements Comparable<Person> {
    private String name;
    private int birthYear;

    public Person() {
        name = "";
        birthYear = 0;
    }

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Person other = (Person) obj;
        if (name.equalsIgnoreCase(other.name) && birthYear == other.birthYear) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
    }

    public int compareTo(Person p) {
        Person other = (Person)p;
        return Integer.compare(birthYear, other.birthYear);
    }


}
