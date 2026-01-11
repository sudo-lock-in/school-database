public class GeneralStaff extends Employee {
    private String duty;
    public GeneralStaff() {
        duty = "";
    }

    public GeneralStaff(String duty) {
        this.duty = duty;
    }

    public GeneralStaff(String deptName, String duty) {
        setDeptName(deptName);
        this.duty = duty;
    }

    public GeneralStaff(String name, int birthYear, String deptName, String duty) {
        setName(name);
        setBirthYear(birthYear);
        setDeptName(deptName);
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public boolean equals(Object obj) {
        GeneralStaff other = (GeneralStaff)obj;
        if (super.equals(obj) && duty.equalsIgnoreCase(other.duty)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return super.toString() +  String.format(" GeneralStaff: Duty: %10s", duty);
    }

}
