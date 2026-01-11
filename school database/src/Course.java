import java.lang.Comparable;
import java.util.*;

public class Course implements Comparable<Course> {
    private boolean isGraduateCourse;
    private int courseNum;
    private String courseDept;
    private int numCredits;

    public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
        this.isGraduateCourse = isGraduateCourse;
        this.courseNum = courseNum;
        this.courseDept = courseDept;
        this.numCredits = numCredits;
    }

    public boolean isGraduateCourse() {
        return isGraduateCourse;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getCourseName() {
        if (isGraduateCourse) {
            return "G" + courseDept + courseNum;
        }
        return "U" + courseDept + courseNum;
    }

    public String getCourseDept() {
        return courseDept;
    }

    public int getNumCredits() {
        return numCredits;
    }

    @Override
    public boolean equals(Object o) {
        Course other = (Course)o;
        if (numCredits == other.numCredits && courseNum == other.courseNum
                && courseDept.equalsIgnoreCase(other.courseDept) && isGraduateCourse == other.isGraduateCourse) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (isGraduateCourse) {
            return String.format("Course: %3s-%3d | Number of Credits: %02d | Graduate", courseDept, courseNum, numCredits);

        }
        return String.format("Course: %3s-%3d | Number of Credits: %02d | Undergraduate", courseDept, courseNum, numCredits);

    }

    public int compareTo(Course c) {
        Course other = (Course)c;
        return Integer.compare(courseNum, other.courseNum);

    }
    }


