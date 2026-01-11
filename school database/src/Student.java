import java.util.Arrays;

public class Student extends Person implements Comparable<Person> {
    private static int numStudents = 0;
    private int studentID;
    private Course[] coursesTaken = new Course[50];
    private int numCoursesTaken;
    private boolean isGraduate;
    private String major = "undeclared";

    public Student() {
        studentID = ++numStudents;
        coursesTaken = new Course[50];
        numCoursesTaken = 0;
        isGraduate = false;
    }
    public Student(boolean isGraduate) {
        studentID = ++numStudents;
        coursesTaken = new Course[50];
        numCoursesTaken = 0;
        this.isGraduate = isGraduate;
    }
    public Student(String major, boolean isGraduate) {
        studentID = ++numStudents;
        coursesTaken = new Course[50];
        numCoursesTaken = 0;
        this.major = major;
        this.isGraduate = isGraduate;
    }
    public Student(String name, int birthYear, String major, boolean isGraduate) {
        coursesTaken = new Course[50];
        studentID = ++numStudents;
        numCoursesTaken = 0;
        this.major = major;
        this.isGraduate = isGraduate;
        setName(name);
        setBirthYear(birthYear);
    }

    public boolean isGraduate() { return isGraduate; }
    public int getNumCoursesTaken() { return numCoursesTaken; }
    public static int getNumStudents() { return numStudents; }

    public int getStudentID() { return studentID; }
    public String getMajor() {
        return major;
    }

    public void setIsGraduate(boolean isGraduate) {
        this.isGraduate = isGraduate;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public void addCourseTaken (Course course) {
        if (course != null && numCoursesTaken < coursesTaken.length) {
            coursesTaken[numCoursesTaken] = course;
            numCoursesTaken++;
        }
    }

    public void addCoursesTaken (Course[] course) {
        for (int i = 0; i < course.length; i++) {
            addCourseTaken(course[i]);
        }
    }

    public Course getCourseTaken(int index) {
        if (index < 0 || index >= numCoursesTaken || coursesTaken[index] == null) {
            return null;
        }
        return coursesTaken[index];
    }

    public String getCourseTakenAsString(int index) {
        if (getCourseTaken(index) == null) {
            return "";
        }
        return getCourseTaken(index).getCourseDept() + "-" + getCourseTaken(index).getCourseNum();
    }

    public String getAllCoursesTakenAsString() {
        String allCourses = "";
        for (int i = 0; i < numCoursesTaken; i ++) {
            allCourses += coursesTaken[i].toString();
            if (i != numCoursesTaken - 1) {
                allCourses += ", ";
            }
        }
        return allCourses;
    }


    @Override
    public boolean equals(Object obj) {
        Student other = (Student)obj;
        if (super.equals(obj) && numCoursesTaken == other.numCoursesTaken && isGraduate == other.isGraduate
                && Arrays.equals(coursesTaken, other.coursesTaken) && major.equalsIgnoreCase(other.major) && studentID == other.studentID) {
            return true;
        } else {
            return false;
        }
    }


    public String toString() {
        if (isGraduate) {
            return super.toString() +  String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
                    studentID, major, "Graduate", numCoursesTaken, getAllCoursesTakenAsString());
        }
        return super.toString() +  String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
                studentID, major, "Undergraduate", numCoursesTaken, getAllCoursesTakenAsString());
    }
    public int compareTo(Person p) {
        Student other = (Student)p;
        return Integer.compare(numCoursesTaken, other.numCoursesTaken);
    }
}
