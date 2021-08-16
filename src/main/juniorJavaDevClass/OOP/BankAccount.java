package main.juniorJavaDevClass.OOP;

public class BankAccount {
    // Define variables
    String accountNumber;

    // static >> belongs to the CLASS not the object instance
    // final >> constant (often static final)
    final static String routingNumber = "013546";

    // Instance Variable
    String name;
    String ssn;
    String accountType;
    double balance = 0;

    // Constructor definitions: unique methods
        // 1. They are used to define / setup / initialized properties of an object
        // 2. Constructors are IMPLICITLY  called upon instantiation
        // 3. The same name as the class itself
        // 4. Constructors have NO return type
    BankAccount() {
        System.out.println("NEW ACCOUNT CREATED");
    }
    // Overloading: call same constructor with different arguments
    BankAccount(String accountType) {
        System.out.println("NEW ACCOUNT: " + accountType);
    }
    BankAccount(String accountType, double initDeposit) {
        // initDeposit, accountType, Msg are all local variables
        System.out.println("NEW ACCOUNT: " + accountType);
        System.out.println("INITIAL DEPOSIT OF: $" + initDeposit);
        String Msg;
        if (initDeposit < 1000) {
            Msg = "ERROR: Minimum depost must be at least $1,000";
        } else {
            Msg = "Thanks for your initial deposit of: $" + initDeposit;
        }
        System.out.println(Msg);
        balance = initDeposit;
    }

    // Define methods
    void deposit() {

    }

    void withdraw() {

    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    void getStatus() {

    }

}
