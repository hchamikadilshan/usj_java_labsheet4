import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Student {

    // Decalring Variables
    public String name;
    private String address;
    private String teleNo;
    private String school;
    private String dateOfRegister;
    public String feeType;
    public ArrayList<Assignment> assignments;
    public ArrayList<Attendance> attendances;
    public ArrayList<Payment> payments;

    public Student(String name, String address, String teleNo ,String school, String dateOfRegister,String feeType){
        this.name = name;
        this.address = address;
        this.teleNo = teleNo;
        this.school = school;
        this.dateOfRegister = dateOfRegister;
        this.feeType = feeType;
        this.assignments = new ArrayList<Assignment>();
        this.attendances = new ArrayList<Attendance>();
        this.payments = new ArrayList<Payment>();
    }

    public void submitAssignment(int assignmentId, int marks){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date dateOfRegister = new Date();
        assignments.add(new Assignment(assignmentId, dateFormat.format(dateOfRegister), marks));
        System.out.println(String.format("%d %d", assignmentId, marks));
    }
    
    public void markAttendance(String attendanceString){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String attendaStringFinal;
        if (attendanceString == "p"){
            attendaStringFinal = "Present";
        }else{
            attendaStringFinal = "Absent";
        }
        attendances.add(new Attendance(dateFormat.format(date), attendaStringFinal));
    }

    public void makePayment(String month,String paymentType){
        int amount = 0;
        System.out.println(paymentType);
        if (paymentType == "Full"){
            System.out.println(amount);
            amount = 1000;
            System.out.println(amount);
        }else if(paymentType == "Half"){
            amount = 500;
        };
        System.out.println(amount);
        payments.add(new Payment(month, amount));
    }
    @SuppressWarnings("unchecked")
    public ArrayList checkStudentProgress(){
        return assignments;
    }
    public String getName(){
        return name;
    }

}
