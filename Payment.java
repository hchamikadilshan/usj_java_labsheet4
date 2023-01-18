public class Payment {
    public String month;
    public String feeType;
    public int amount;

    public Payment(String month,int amount){
        this.month = month;
        this.amount = amount;
    }

    public String getMonth(){
        return month;
    }

}
