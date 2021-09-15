package juniorJavaDevClass.Labs.Lab4;

/*
Lab 4 - Collections Framework
Create a Credit Card Statement reader application:
    - Read a credit card CSV statement
    - Creating a balance variable that calculates the running balance of the user's account
    - If the field says CREDIT, then add the amount to the balance
    - If the field says DEBIT, then subtract the amount to the balance
    - If the final amount is greater than zero, charge a 10% fee and warn the user
    - If the final amount is zero, than the user for their payments
    - If the final amount is less than zero, thank the user for their payments and display their overpayment
 */

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreditCardStatement {

    public static void main(String[] args) {

        // Read the statement csv file
        List<String[]> data = new ArrayList<>();
        Path path = Paths.get("src/main/resources").resolve("creditCardStatement.csv");
        File file = path.toFile();
        String statementRow;
        double balance = 0;
        double fee = 0.10;

        try {
            // Open the file
            BufferedReader br = new BufferedReader(new FileReader(file));

            // Read the data as long as it's not empty
            while ((statementRow = br.readLine()) != null) {
                // Parse the data by commas
                String[] line = statementRow.split(",");
                // add the data to the collection
                data.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // process activity
        for (String[] activity : data) {
            //System.out.println(Arrays.toString(activity));
            CreditCardActivity activityRow = new CreditCardActivity(activity);
            if (activityRow.activity.equals("CREDIT")) {
                balance = activityRow.credit(balance, activityRow.activityAmount);
            } else if (activityRow.activity.equals("DEBIT")) {
                balance = activityRow.debit(balance, activityRow.activityAmount);
            } else if (activityRow.activity.equals("FEE")) {
                balance = activityRow.fee(balance, activityRow.activityAmount);
            }
        }

        if (balance > 0) {
            System.out.println("You have a statement balance of: $" + String.format("%.2f", balance));
            double feeAmount = balance * fee;
            balance += feeAmount;
            System.out.println("Statement balance interest fee of 10% is being applied.");
            System.out.println("ACCT ACTIVITY: Statement interest fee $" + String.format("%.2f", feeAmount));
            System.out.println("Your new balance is: $" + String.format("%.2f", balance));
        } else if (balance == 0) {
            System.out.println("Thank you for your payments.");
            System.out.println("Your current balance is 0");
        } else {
            double overPayAmt = balance * -1;
            System.out.println("Thank you for your payments.");
            System.out.println("You have overpaid your statement by $" + String.format("%.2f", overPayAmt));
        }
    }
}
