import java.util.*;

public class Employee extends Person implements Comparable<Person>{
    private String deptName;
    private static int numEmployees = 0;
    private int employeeID;

    public Employee() {
        deptName = "";
        employeeID = ++numEmployees;
    }

    public Employee (String deptName) {
        this.deptName = deptName;
        employeeID = ++numEmployees;
    }

    public Employee(String name, int birthYear, String deptName) {
        employeeID = ++numEmployees;
        setName(name);
        setBirthYear(birthYear);
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public static int getNumEmployees() {
        return numEmployees;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object obj) {
        Employee other = (Employee)obj;
        if (super.equals(obj) && employeeID == other.employeeID && deptName.equalsIgnoreCase(other.deptName)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return super.toString() +  String.format(" Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
    }
    public int compareTo(Person p) {
        Employee other = (Employee)p;
        return Integer.compare(employeeID, other.employeeID);
    }
}
