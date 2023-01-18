import java.util.Scanner;

import javax.lang.model.type.NullType;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;




// public void enrollNewStudent(){
//     students.add(new Student(name,address,teleNo,school,dateOfRegister,feeType));}

public class Main {

    static List<Student>students = new ArrayList<Student>();
    static ArrayList<Batch> batches = new ArrayList<Batch>();
    static ArrayList<Course> courses = new ArrayList<Course>();

    public static void createNewBatch(){
        Batch batch = new Batch();
        batches.add(batch);
        System.out.println(String.format("Batch %d Created",batch.number));
        mainMenu();
        
    }


    public static void createNewCourse(){
        System.out.println("Enter Course Name:");
        Scanner scanner = new Scanner(System.in);
        String course_name = scanner.nextLine();
        Course course = new Course(course_name);
        courses.add(course);
        mainMenu();
    }

    public static void addNewStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name :");
        String name = scanner.nextLine();
        System.out.println("Enter Address :");
        String address = scanner.nextLine();
        System.out.println("Enter Telephone No :");
        String teleNo = scanner.nextLine();
        System.out.println("Enter School :");
        String school = scanner.nextLine();
        System.out.println("Enter Registered Date(yyyy/mm/dd) :");
        String dateRegistered = scanner.nextLine();
        System.out.println("Enter Fee Type(Fee/Half) :");
        String feeType = scanner.nextLine();
        

        Student student = new Student(name,address,teleNo,school,dateRegistered,feeType);
        students.add(student);
        System.out.println(String.format("Student '%s' Enrolled",student.name));
        mainMenu();

    }

    public static void submitAssignment(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name :");
        String name = scanner.nextLine();
        System.out.println("Enter Assignment ID :");
        int assignmentId = scanner.nextInt();
        System.out.println("Enter Marks :");
        int marksObtained = scanner.nextInt();

        // for (Student st : students){
        //     System.out.println(st.name);
        // };
        students.stream().filter(st -> (st.getName().equals(name))).
            forEachOrdered( st -> {
                // if (st == null){
                //     System.out.println("Invalid Student Name !");
                // }
                System.out.println(st.name);
                st.submitAssignment(assignmentId, marksObtained);
        }
        );
        mainMenu();
    }
    
    @SuppressWarnings("unchecked")
    public static void getStudentProgress(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name :");
        String name = scanner.nextLine();

        students.stream().filter(st -> (st.getName().equals(name))).
        forEachOrdered(st -> {
            ArrayList<Assignment> studentMarks = st.checkStudentProgress();
            System.out.println("____________________________________________________________________________");
            System.out.println("\t\t__________________Student Progress_____________");
            System.out.println(String.format("Student Name :%s", st.name));
            for (Assignment ass :studentMarks){
                    
                    System.out.println(String.format("Assignment ID :%d Marks :%d Date Submited :%s Completed :%b",ass.assignmentId,ass.marksObtained,ass.dateOfSubmision,ass.completed));
            }
        });
        mainMenu();
    }
    public static void markAttendance(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name :");
        String name = scanner.nextLine();
        System.out.println("Enter Attendance (p/a) :");
        String attendance = scanner.nextLine();

        students.stream().filter(st -> (st.getName().equals(name))).
        forEachOrdered(st -> {
            st.markAttendance(attendance);
            System.out.println(String.format("Attendance Marked for Student %s",st.name));
    });
        mainMenu();
    }

    public static void mainMenu(){
        System.out.println("____________________________________________________________________________");
        System.out.println("\t\t               WELCOME TO TUITION CLASS MANAGEMENT SYSTEM");
        System.out.println("\t\t______________Main Menu__________");
        System.out.println("                                               \n");
        System.out.println("\t|Press 1 CREATE NEW BATCH               |");
        System.out.println("\t|Press 2 CREATE NEW COURSE              |");
        System.out.println("\t|Press 3 ADD NEW STUDENT                |");
        System.out.println("\t|Press 4 SUBMIT ASSIGNMENT              |");
        System.out.println("\t|Press 5 STUDENT PROGRESS               |");
        System.out.println("\t|Press 6 MARK ATTENDANCE                |");
        System.out.println("\t|Press 6 EXIT                           |");


        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                createNewBatch();
                break;
            case 2:
                createNewCourse();
            case 3:
                addNewStudent();
            case 4:
                submitAssignment();
            case 5:
                getStudentProgress();
            case 6:
                markAttendance();
            default:

                System.out.println("\t\t  PLEASE SELECT ONLY A GIVEN OPTION   "
                        + "\n\n");
                break;   
        }
        mainMenu();

    }
    public static void main(String [] args){
        mainMenu();

    }
}
