package juniorJavaDevClass.Labs.Lab4;

public class CreditCardActivity {

    // instance variables
    double currentBalance;
    String date;
    String activity;
    String description;
    double activityAmount;
    String balanceToPrint;
    String activityToPrint;

    // constructor
    CreditCardActivity (String[] activity) {
        this.date = activity[0];
        this.activity = activity[1];
        this.description = activity[2];
        this.activityAmount = Double.parseDouble(activity[3]);
    }

    // credit activity method
    public double credit(double balance, double amount) {
        currentBalance = balance + amount;
        System.out.println(toString());
        return currentBalance;
    }

    // debit activity method
    public double debit(double balance, double amount) {
        currentBalance = balance - amount;
        System.out.println(toString());
        return currentBalance;
    }

    // fee method
    public double fee(double balance, double amount) {
        currentBalance = balance + amount;
        System.out.println(toString());
        return currentBalance;
    }

    // interestFee method
    public double interest(double balance, double interestFee) {
        if (balance > 0) {
            double feeAmount = balance * interestFee;
            currentBalance = balance + feeAmount;
            System.out.println("You have a statement balance of: $" + String.format("%.2f", balance));
            System.out.println("Statement balance interest fee of 10% is being applied.");
            System.out.println(toString());
        }
        return currentBalance;
    }


    @Override
    public String toString() {
        balanceToPrint = String.format("%.2f",currentBalance);
        activityToPrint = String.format("%.2f",activityAmount);
        String msg1 = "ACCT ACTIVITY: " + date + " " + activity + " " + description + " $" + activityToPrint;
        String msg2 = "\nYour new balance is: $" + balanceToPrint;
        return msg1 + msg2;

    }
}
