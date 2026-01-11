import java.util.*;
import java.io.*;

public class Driver_SchoolDB {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);
        //general names to be reused for each class
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Faculty> faculties = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<GeneralStaff> staffs = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        boolean trueFalse;
        int num1;
        String s1;
        int num2;
        String s2;
        String s3;
       for (int i = 0; i < 3; i++) {
           System.out.println("Creating Course");
           System.out.println("Graduate course? true or false:");
           trueFalse = scnr.nextBoolean();
           System.out.println("Enter course number:");
           num1 = scnr.nextInt();
           System.out.println("Enter course department:");
           scnr.nextLine();
           s1 = scnr.nextLine();
           System.out.println("Enter number of credits:");
           num2 = scnr.nextInt();
           Course addedCourse = new Course(trueFalse, num1, s1, num2);
           courses.add(addedCourse);
       }
       System.out.println("\nCOURSES:");
       courses.forEach(System.out::println); //tip found online to print out each object's string value in the arraylist at once using .forEach() method
       for (int i = 0; i < 3; i++) {
           System.out.println("\nCreating Faculty");
           System.out.println("Enter name:");
           scnr.nextLine();
           s1 = scnr.nextLine();
           System.out.println("Enter birth year:");
           num1 = scnr.nextInt();
           System.out.println("Enter department:");
           scnr.nextLine();
           s2 = scnr.nextLine();
           System.out.println("Tenured? true or false:");
           trueFalse = scnr.nextBoolean();
           Faculty addedFaculty = new Faculty(s1, num1, s2, trueFalse);
           faculties.add(addedFaculty);
       }
       System.out.println("\nFACULTY:");
       faculties.forEach(System.out::println);
       for (int i = 0; i < 3; i++) {
           System.out.println("\nCreating General Staff");
           System.out.println("Enter name:");
           if (i == 0) {
               scnr.nextLine();
           }
           s1 = scnr.nextLine();
           System.out.println("Enter birth year:");
           num1 = scnr.nextInt();
           System.out.println("Enter department:");
           scnr.nextLine();
           s2 = scnr.nextLine();
           System.out.println("Enter duty:");
           s3 = scnr.nextLine();
           GeneralStaff addedStaff = new GeneralStaff(s1, num1, s2, s3);
           staffs.add(addedStaff);
       }
       System.out.println("\nGENERAL STAFF:");
       staffs.forEach(System.out::println);
       for (int i = 0; i < 3; i++) {
           System.out.println("\nCreating Student");
           System.out.println("Enter name:");
           if (i != 0) {
               scnr.nextLine();
           }
           s1 = scnr.nextLine();
           System.out.println("Enter birth year:");
           num1 = scnr.nextInt();
           System.out.println("Enter major:");
           scnr.nextLine();
           s2 = scnr.nextLine();
           System.out.println("Graduate student? true or false:");
           trueFalse = scnr.nextBoolean();
           Student addedStudent = new Student(s1, num1, s2, trueFalse);
           students.add(addedStudent);
       }
       System.out.println("\nSTUDENTS:");
       students.forEach(System.out::println);
       for (int i = 0; i < 2; i++) {
           System.out.println("\nAdding new Courses to Faculty object");
           System.out.println("Creating Course");
           System.out.println("Graduate course? true or false:");
           trueFalse = scnr.nextBoolean();
           System.out.println("Enter course number:");
           num1 = scnr.nextInt();
           System.out.println("Enter course department:");
           scnr.nextLine();
           s1 = scnr.nextLine();
           System.out.println("Enter number of credits:");
           num2 = scnr.nextInt();
           Course addedCourse = new Course(trueFalse, num1, s1, num2);
           System.out.println("\nEnter which Faculty object to add the new Course to (1, 2, or 3):");
           faculties.forEach(System.out::println);
           int index = scnr.nextInt() - 1;
           faculties.get(index).addCourseTaught(addedCourse);
           courses.add(addedCourse);
       }
       System.out.println("\nUPDATED FACULTY:");
       faculties.forEach(System.out::println);
       System.out.println("\nUPDATED COURSES:");
       courses.forEach(System.out::println);

       for (int i = 0; i < 2; i++) {
           System.out.println("\nAdding new Courses to Student object");
           System.out.println("Creating Course");
           System.out.println("Graduate course? true or false:");
           trueFalse = scnr.nextBoolean();
           System.out.println("Enter course number:");
           num1 = scnr.nextInt();
           System.out.println("Enter course department:");
           scnr.nextLine();
           s1 = scnr.nextLine();
           System.out.println("Enter number of credits:");
           num2 = scnr.nextInt();
           Course addedCourse = new Course(trueFalse, num1, s1, num2);
           System.out.println("\nEnter which Student object to add the new Course to (1, 2, or 3):");
           students.forEach(System.out::println);
           int index = scnr.nextInt() - 1;
           students.get(index).addCourseTaken(addedCourse);
           courses.add(addedCourse);
       }
       System.out.println("\nUPDATED STUDENTS:");
       students.forEach(System.out::println);
       System.out.println("\nUPDATED COURSES:");
       courses.forEach(System.out::println);

       System.out.println("\nAdding array of 2 new Courses to Faculty object");
       Course[] courseArray = new Course[2];
       Course c1 = null;
       for (int i = 0; i < 2; i++) {
           System.out.println("\nCreating Course");
           System.out.println("Graduate course? true or false:");
           trueFalse = scnr.nextBoolean();
           System.out.println("Enter course number:");
           num1 = scnr.nextInt();
           System.out.println("Enter course department:");
           scnr.nextLine();
           s1 = scnr.nextLine();
           System.out.println("Enter number of credits:");
           num2 = scnr.nextInt();
           if (c1 == null) {
               c1 = new Course(trueFalse, num1, s1, num2);
               courseArray[0] = c1;
               courses.add(c1);
           } else {
               Course c2 = new Course(trueFalse, num1, s1, num2);
               courseArray[1] = c2;
               courses.add(c2);
           }
       }
       System.out.println("\nEnter which Faculty object to add the new Courses to (1, 2, or 3):");
       faculties.forEach(System.out::println);
       int index = scnr.nextInt() - 1;
       faculties.get(index).addCoursesTaught(courseArray);
       System.out.println("\nUPDATED FACULTY:");
       faculties.forEach(System.out::println);
       System.out.println("\nUPDATED COURSES:");
       courses.forEach(System.out::println);

       System.out.println("\nAdding array of 2 new Courses to Student object");
       c1 = null;
       for (int i = 0; i < 2; i++) {
           System.out.println("Creating Course");
           System.out.println("Graduate course? true or false:");
           trueFalse = scnr.nextBoolean();
           System.out.println("Enter course number:");
           num1 = scnr.nextInt();
           System.out.println("Enter course department:");
           scnr.nextLine();
           s1 = scnr.nextLine();
           System.out.println("Enter number of credits:");
           num2 = scnr.nextInt();
           if (c1 == null) {
               c1 = new Course(trueFalse, num1, s1, num2);
               courseArray[0] = c1;
               courses.add(c1);
           } else {
               Course c2 = new Course(trueFalse, num1, s1, num2);
               courseArray[1] = c2;
               courses.add(c2);
           }
       }
       System.out.println("\nEnter which Student object to add the new Courses to (1, 2, or 3):");
       students.forEach(System.out::println);
       index = scnr.nextInt() - 1;
       students.get(index).addCoursesTaken(courseArray);
       System.out.println("\nUPDATED STUDENTS:");
       students.forEach(System.out::println);
       System.out.println("\nUPDATED COURSES:");
       courses.forEach(System.out::println);

       System.out.println("\nGet Faculty object Course at index");
       System.out.println("\nEnter Faculty object to get Course from (1, 2, or 3):");
       faculties.forEach(System.out::println);
       index = scnr.nextInt() - 1;
       boolean found1 = false;
       while (!found1) {
           System.out.println("\nEnter index of Course:");
           int courseIndex = scnr.nextInt();
           found1 = true;
           if (students.get(index).getNumCoursesTaken() == 0) {
               System.out.println("No courses being taken!");
           } else if (faculties.get(index).getCourseTaught(courseIndex) == null) {
               System.out.println("\nInvalid index. Try again.");
               found1 = false;
           } else {
               System.out.println("\nCOURSE AT INDEX " + courseIndex + " IN FACULTY OBJECT:");
               System.out.println(faculties.get(index).getCourseTaught(courseIndex));
           }
       }
       System.out.println("\nGet Student object Course at index");
       System.out.println("\nEnter Student object to get Course from (1, 2, or 3):");
       students.forEach(System.out::println);
       index = scnr.nextInt() - 1;
       boolean found2 = false;
       while (!found2) {
           System.out.println("\nEnter index of Course:");
           int courseIndex = scnr.nextInt();
           found2 = true;
           if (students.get(index).getNumCoursesTaken() == 0) {
               System.out.println("No courses being taken!");
           }
           else if (students.get(index).getCourseTaken(courseIndex) == null) {
               System.out.println("\nInvalid index. Try again.");
               found2 = false;
           } else {
               System.out.println("\nCOURSE AT INDEX " + courseIndex + " IN STUDENT OBJECT:");
               System.out.println(students.get(index).getCourseTakenAsString(courseIndex));
           }
       }

       System.out.println("\nDetermine if Course is taught by Faculty object");
       System.out.println("\nSelect a Faculty object (1, 2, or 3):");
       faculties.forEach(System.out::println);
       index = scnr.nextInt() - 1;
       System.out.println("\nSelect a Course object 1-" + courses.size());
       courses.forEach(System.out::println);
       int courseIndex = scnr.nextInt();
       if (faculties.get(index).getAllCoursesTaughtAsString().contains(courses.get(courseIndex).toString())) {
           System.out.println("\nFaculty teaches Course");
       } else {
           System.out.println("\nFaculty does not teach Course");
       }

       int mostTaught = faculties.get(0).getNumCoursesTaught();
       int leastTaught = faculties.get(0).getNumCoursesTaught();
       Faculty teachesMost = faculties.get(0);
       Faculty teachesLeast = faculties.get(0);
       for (int i  = 1; i < faculties.size(); i++) {
           if (faculties.get(i).getNumCoursesTaught() > mostTaught) {
               teachesMost = faculties.get(i);
           } else if (faculties.get(i).getNumCoursesTaught() < leastTaught) {
               teachesLeast = faculties.get(i);
           }
       }
       System.out.println("\nFaculty that teaches the most:");
       System.out.println(teachesMost);
       System.out.println("\nFaculty that teaches the least:");
       System.out.println(teachesLeast);

       System.out.println("\nMinimum Course of all Course objects:");
       System.out.println(Collections.min(courses));
       System.out.println("\nMaximum Course of all Course objects:");
       System.out.println(Collections.max(courses));


       int[] studentCredits = new int[3];
       for (int i = 0; i < students.get(0).getNumCoursesTaken(); i++) {
           studentCredits[0] += students.get(0).getCourseTaken(i).getNumCredits();
       }
       for (int i = 0; i < students.get(1).getNumCoursesTaken(); i++) {
           studentCredits[1] += students.get(1).getCourseTaken(i).getNumCredits();
       }
       for (int i = 0; i < students.get(2).getNumCoursesTaken(); i++) {
           studentCredits[2] += students.get(2).getCourseTaken(i).getNumCredits();
       }

       int mostCredits = studentCredits[0];
       int leastCredits = studentCredits[0];
       Student hasLeastCreds = students.get(0);
       Student hasMostCreds = students.get(0);
       for (int i = 1; i < students.size(); i++) {
           if (studentCredits[i] > mostCredits) {
               hasMostCreds = students.get(i);
           } else if (studentCredits[i] < mostCredits) {
               hasLeastCreds = students.get(i);
           }
       }
       System.out.println("\nStudent with the least credits:");
       System.out.println(hasLeastCreds);
       System.out.println("\nStudent with the most credits:");
       System.out.println(hasMostCreds);

        String[] content = null;
        String lineContent = "";
        //clearing for next part
        courses.clear();
        faculties.clear();
        staffs.clear();
        students.clear();
        Scanner inStream = new Scanner(new File("SchoolDB_Initial.txt"));
        while (inStream.hasNextLine()) {
            lineContent = inStream.nextLine();
            System.out.println(lineContent);
            if (lineContent.contains(":")) {
                content = lineContent.substring(lineContent.indexOf(":")).replace(":", "").strip().split(",");
            }
            //there could be edge cases but this is all under the assumption the input from file has no wrong inputs
            if (lineContent.startsWith("Course")) {
                trueFalse = Boolean.valueOf(content[0].strip());
                num1 = Integer.valueOf(content[1].strip());
                s1 = content[2].strip();
                num2 = Integer.valueOf(content[3].strip());
                Course addedCourse = new Course(trueFalse, num1, s1, num2);
                courses.add(addedCourse);
            } else if (lineContent.startsWith("Faculty:")) {
                if (content.length == 0) {
                    Faculty addedFaculty = new Faculty();
                    faculties.add(addedFaculty);
                } else if (content.length == 1) {
                    trueFalse = Boolean.valueOf(content[0].strip());
                    Faculty addedFaculty = new Faculty(trueFalse);
                    faculties.add(addedFaculty);
                } else if (content.length == 2) {
                    s1 = content[0].strip();
                    trueFalse = Boolean.valueOf(content[1].strip());
                    Faculty addedFaculty = new Faculty(s1, trueFalse);
                    faculties.add(addedFaculty);
                } else if (content.length == 4) {
                    s1 = content[0].strip();
                    num1 = Integer.valueOf(content[1].strip());
                    s2 = content[2].strip();
                    trueFalse = Boolean.valueOf(content[3].strip());
                    Faculty addedFaculty = new Faculty(s1, num1, s2, trueFalse);
                    faculties.add(addedFaculty);
                }
            } else if (lineContent.startsWith("Student")) {
                if (content.length == 0) {
                    Student addedStudent = new Student();
                    students.add(addedStudent);
                } else if (content.length == 1) {
                    trueFalse = Boolean.valueOf(content[0].strip());
                    Student addedStudent = new Student(trueFalse);
                    students.add(addedStudent);
                } else if (content.length == 2) {
                    s1 = content[0].strip();
                    trueFalse = Boolean.valueOf(content[1].strip());
                    Student addedStudent = new Student(s1, trueFalse);
                    students.add(addedStudent);
                } else if (content.length == 4) {
                    s1 = content[0].strip();
                    num1 = Integer.valueOf(content[1].strip());
                    s2 = content[2].strip();
                    trueFalse = Boolean.valueOf(content[3].strip());
                    Student addedStudent = new Student(s1, num1, s2, trueFalse);
                    students.add(addedStudent);
                }
            } else if (lineContent.startsWith("GeneralStaff")) {
                if (content.length == 0) {
                    GeneralStaff addedStaff = new GeneralStaff();
                    staffs.add(addedStaff);
                } else if (content.length == 1) {
                    s1 = content[0].strip();
                    GeneralStaff addedStaff = new GeneralStaff(s1);
                    staffs.add(addedStaff);
                } else if (content.length == 2) {
                    s1 = content[0].strip();
                    s2 = content[1].strip();
                    GeneralStaff addedStaff = new GeneralStaff(s1, s2);
                    staffs.add(addedStaff);
                } else if (content.length == 4) {
                    s1 = content[0].strip();
                    num1 = Integer.valueOf(content[1].strip());
                    s2 = content[2].strip();
                    s3 = content[3].strip();
                    GeneralStaff addedStaff = new GeneralStaff(s1, num1, s2, s3);
                    staffs.add(addedStaff);
                }
            } else if (lineContent.startsWith("Person")) {
                if (content.length == 0) {
                    Person addedPerson = new Person();
                    people.add(addedPerson);
                } else if (content.length == 2) {
                    s1 = content[0].strip();
                    num1 = Integer.valueOf(content[1].strip());
                    Person addedPerson = new Person(s1, num1);
                    people.add(addedPerson);
                }
            } else if (lineContent.startsWith("Employee")) {
                if (content.length == 0) {
                    Employee addedEmployee = new Employee();
                    employees.add(addedEmployee);
                } else if (content.length == 1) {
                    s1 = content[0].strip();
                    Employee addedEmployee = new Employee(s1);
                    employees.add(addedEmployee);
                } else if (content.length == 3) {
                    s1 = content[0].strip();
                    num1 = Integer.valueOf(content[1].strip());
                    s2 = content[2].strip();
                    Employee addedEmployee = new Employee(s1, num1, s2);
                    employees.add(addedEmployee);
                }
            }
        }
        //print to console
        System.out.println("\n**************************************************************");
        System.out.println("SCHOOL DATABASE INFO:\n");
        System.out.println("************************************************");
        System.out.println("COURSES:");
        courses.forEach(System.out::println);
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("PERSONS:");
        people.forEach(System.out::println);
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("EMPLOYEES:");
        employees.forEach(System.out::println);
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("GENERAL STAFF:");
        staffs.forEach(System.out::println);
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("FACULTY:");
        faculties.forEach(System.out::println);
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("STUDENTS:");
        students.forEach(System.out::println);
        System.out.println("************************************************");
        System.out.println("**************************************************************\n");

        //print to file
        PrintWriter writer = new PrintWriter(new FileOutputStream("SchoolDB_Updated.txt", true));
        writer.println("\n**************************************************************");
        writer.println("SCHOOL DATABASE INFO:\n");
        writer.println("************************************************");
        writer.println("COURSES:");
        courses.forEach(writer::println);
        writer.println("************************************************");
        writer.println("************************************************");
        writer.println("PERSONS:");
        people.forEach(writer::println);
        writer.println("************************************************");
        writer.println("************************************************");
        writer.println("EMPLOYEES:");
        employees.forEach(writer::println);
        writer.println("************************************************");
        writer.println("************************************************");
        writer.println("GENERAL STAFF:");
        staffs.forEach(writer::println);
        writer.println("************************************************");
        writer.println("************************************************");
        writer.println("FACULTY:");
        faculties.forEach(writer::println);
        writer.println("************************************************");
        writer.println("************************************************");
        writer.println("STUDENTS:");
        students.forEach(writer::println);
        writer.println("************************************************");
        writer.println("**************************************************************\n");
        writer.flush();
        }
    }
