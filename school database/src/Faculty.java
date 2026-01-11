import java.util.*;

public class Faculty extends Employee implements Comparable<Person>{
    private Course[] coursesTaught = new Course[100];
    private int numCoursesTaught;
    private boolean isTenured;

    public Faculty() {
        coursesTaught =  new Course[100];
        numCoursesTaught = 0;
        isTenured = false;
    }

    public Faculty(boolean isTenured) {
        coursesTaught  = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(String deptName, boolean isTenured) {
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
        setDeptName(deptName);
    }

    public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
        setName(name);
        setBirthYear(birthYear);
        numCoursesTaught = 0;
        coursesTaught = new Course[100];
        setDeptName(deptName);
        this.isTenured = isTenured;
    }

    public boolean isTenured() {
        return isTenured;
    }

    public int getNumCoursesTaught() {
        return numCoursesTaught;
    }

    public void setIsTenured(boolean isTenured) {
        this.isTenured = isTenured;
    }

    public void addCourseTaught (Course course) {
        if (course != null && numCoursesTaught < coursesTaught.length) {
            coursesTaught[numCoursesTaught] = course;
            numCoursesTaught++;
        }
    }

    public void addCoursesTaught (Course[] course) {
        for (int i = 0; i < course.length; i++) {
            addCourseTaught(course[i]);
        }
    }

    public Course getCourseTaught(int index) {
        if (index < 0 || index >= numCoursesTaught || coursesTaught[index] == null) {
            return null;
        }
        return coursesTaught[index];
    }

    public String getCourseTaughtAsString(int index) {
        if (getCourseTaught(index) == null) {
            return "";
        }
        return getCourseTaught(index).toString();
    }

    public String getAllCoursesTaughtAsString() {
        String allCourses = "";
        for (int i = 0; i < numCoursesTaught; i ++) {
                allCourses += coursesTaught[i].toString();
                if (i != numCoursesTaught - 1) {
                    allCourses += ", ";
            }
        }
        return allCourses;
    }


    @Override
    public boolean equals(Object obj) {
        Faculty other = (Faculty)obj;
        if (super.equals(obj) && numCoursesTaught == other.numCoursesTaught && isTenured == other.isTenured
                && Arrays.equals(coursesTaught, other.coursesTaught)) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        if (isTenured) {
            return super.toString() +  String.format(" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s", "Is Tenured", numCoursesTaught, getAllCoursesTaughtAsString());
        }
        return super.toString() +  String.format(" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s", "Not Tenured", numCoursesTaught, getAllCoursesTaughtAsString());
    }
    public int compareTo(Person p) {
        Faculty other = (Faculty)p;
        return Integer.compare(numCoursesTaught, other.numCoursesTaught);
    }

}
