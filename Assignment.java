import java.util.Date;

public class Assignment {
    public int assignmentId;
    public String dateOfSubmision;
    public int marksObtained;
    public Boolean completed;

    public Assignment(int assignmentId,String dateOfSubmission ,int marksObtained){
        this.assignmentId = assignmentId;
        this.dateOfSubmision = dateOfSubmission;
        this.marksObtained = marksObtained;
        this.completed = checkAssignmentSatus(marksObtained);
    }
    
    @SuppressWarnings("unchecked")
    public boolean checkAssignmentSatus(int marksObtained){
        boolean status;
        if (marksObtained > 40){
            status = true;
        }else {
            status = false;
        }
        return status;
    }
}
