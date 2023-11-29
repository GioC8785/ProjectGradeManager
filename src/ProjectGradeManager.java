import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class ProjectGradeManager {
    /* STEPS TAKEN WHEN WRITING THIS CODE
    1) Import Scanner for input.
    2) Bring in a constant value, that can be easily changed. STUDENT_COUNT
    3) DECLARE STATIC VARIABLES, names and grades that can be accessed in any scope of the code.
    4) EACH METHOD HAS ITS OWN BLOCK, EXPLAINING ITS FUNCTION
     */

    static int STUDENT_COUNT;
    static Scanner sc = new Scanner(System.in);

    static {
        System.out.println("Enter Number of Students: ");
        STUDENT_COUNT = sc.nextInt();
    }

    static String[] studentNames = new String[STUDENT_COUNT];
    static int[] studentGrades = new int[STUDENT_COUNT];

    public static void main(String[] args) {

//        System.out.println("Enter Number of Students: ");
//
//        STUDENT_COUNT = sc.nextInt();

        navigationMenu();
    }
/*
  EXPLANATION FOR METHOD  ----- navigationMenu
    1) CREATE A MENU FOR THE TEACHER, USE SWITCH CASES, because they are helpful with menu-driven systems.
    2) Use \n, which creates a new line in order to minimize line used for the code // or USE TEXT BLOCK!!!
    3) DO-While loop is an exit condition loop, we want the loop to exit, when the user decides to, so use do-while
    4) USE ENHANCED SWITCH because IntelliJ is amazing. (it recommended the following to me)
    5) BRING IN A CONDITIONAL STATEMENT TO EXIT THE LOOP
 */

    public static void navigationMenu() {


        int choice = 0;
        while (choice != 6) {
            System.out.println
                    ("""
                            Menu:
                            1. Input Student Data:
                            2. Display Student Data
                            3. Calculate Average Grade
                            4. Find Highest and Lowest
                            5. Search Student's Grade
                            6. Exit
                            Enter your choice:
                            """);


            choice = sc.nextInt();
            switch (choice) {
                case 1 -> studentDetails(studentNames, studentGrades);
                case 2 -> displayStudentsGrades();
                case 3 -> averageGrade();
                case 4 -> highestAndLowestGrade();
                case 5 -> searchStudentNames();
                case 6 -> System.out.println("Goodbye Professor Yash!");
            }
        }

    }

    public static void studentDetails(String[] studentNames, int[] studentGrades) {


        for (int i = 0; i < STUDENT_COUNT; i++) {
            sc.nextLine();
            System.out.println("Enter Name: ");
            String name = sc.nextLine();

            System.out.println("Enter grade of " + name + ": ");
            int grade = sc.nextInt();


            if (grade < 0 || grade > 100) {
                System.out.println("Silly Goose, Try again");
                i--;
                continue;
            }

            studentNames[i] = name;
            studentGrades[i] = grade;
        }
    }

    public static void displayStudentsGrades() {
        System.out.println("Name          |       Grade");
        System.out.println("----------------------------");
        for (int i = 0; i < studentNames.length; i++) {
            System.out.println(studentNames[i] + "                    " + studentGrades[i]);
        }
    }

    public static void averageGrade() {

        int sum = 0;
        double average = 0.0;

        for (int i = 0; i < studentGrades.length; i++) {
            sum += studentGrades[i];
            average = (double) sum / STUDENT_COUNT;
        }

        System.out.println("Total Grade is " + sum);
        System.out.println("Class Average is " + average);
    }

    public static void highestAndLowestGrade() {
        int highestGrade = 0;
        String highestStudent = "";
        int lowestGrade = studentGrades[0];
        String lowestStudent = "";


        for (int i = 0; i < STUDENT_COUNT; i++) {
            if (studentGrades[i] > highestGrade) {
                highestGrade = studentGrades[i];
                highestStudent = studentNames[i];
            }
            if (lowestGrade > studentGrades[i]) {
                lowestGrade = studentGrades[i];
                lowestStudent = studentNames[i];
            }
        }

        /*
        FIRST =  COMPARE STUDENT GRADE TO THE HIGHEST GRADE
        BRING IN AN IF STATEMENT. If it matches, remember name.
        Create new Array of The Highest Grade Students
        Second = COMPARE STUDENT GRADE TO THE LOWEST GRADE
        Bring in AN IF STATEMENT, IF it matches, remember name.
        Create a new Array of the Lowest Grade Students.
         */
        String[] highestGradeStudents = new String[STUDENT_COUNT];
        String[] lowestGradeStudents = new String[STUDENT_COUNT];
        int matchingHighGrade = 0;
        int matchingLowGrade = 0;
        for (int i = 0; i < STUDENT_COUNT; i++) {
            if (studentGrades[i] == highestGrade) {
                highestGradeStudents[matchingHighGrade] = studentNames[i];
                matchingHighGrade++;
            }
            if(studentGrades[i] == lowestGrade){
                lowestGradeStudents[matchingLowGrade] = studentNames [i];
                matchingLowGrade++;
            }
        }
        String[] newHighestGradeStudents = new String[matchingHighGrade];
        String[] newLowestGradeStudents = new String[matchingLowGrade];

        for (int i = 0; i < newHighestGradeStudents.length; i++){
            newHighestGradeStudents[i] = highestGradeStudents[i];
        }
        for (int i = 0; i < newLowestGradeStudents.length; i++){
            newLowestGradeStudents [i] = lowestGradeStudents [i];
        }


        System.out.println("Highest Grade is " + highestGrade + " obtained by " + Arrays.toString(newHighestGradeStudents));
        System.out.println("Lowest Grade is " + lowestGrade + " obtained by " + Arrays.toString(newLowestGradeStudents));
    }

    public static void searchStudentNames() {


        System.out.println("Enter students name to get their grade: ");
        sc.nextLine();
        String name = sc.nextLine();


        for (int i = 0; i < studentNames.length; i++) {

            if (studentNames[i].equals(name)) {
                System.out.println("Grade of " + name + ": " + studentGrades[i]);
                break;
            }
        }
    }
}
