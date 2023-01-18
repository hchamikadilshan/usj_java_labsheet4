import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Batch> batches;

    public Course (String name){
        this.name = name;
        // this.batches = new ArrayList<Batch>();
    }

    public void enrollNewBatch (){
        batches.add(new Batch());
    }
}
