package juniorJavaDevClass.Labs.StudentDatabase;

/*
Lab 2 - Object-Oriented Programming
Create a student Database with the following attributes:
    - New Student constructor that takes name and SSN in the arguments
    - Automatically create an email ID based on the name
    - Set a private static ID
    - Generate a user ID that is combination fo Static ID, random 4-digit number between 1000 and 9000, and the last 4 of SSN
    - Methods: enroll(), pay(), toString(), showCourses()
    - use encapsulation to set variables (phone, city, state)
 */

import java.util.Locale;

public class Student {

    private static int iD = 0;
    private String name;
    private String SSN;
    private String email;
    private String userID;
    private String courses = "";
    private int courseCost = 1000;
    private int balance = 0;
    private String phone;
    private String city;
    private String state;

    // constructor
    public Student (String name, String SSN) {
        this.name = name;
        this.SSN = SSN;
        this.email = createEmail(this.name);
        this.userID = genUserID(SSN);
    }

    // create email address method
    public String createEmail(String name) {
        email = name.toLowerCase() + "@school.edu";
        return email;
    }

    // generate user ID method
    public String genUserID(String SSN) {
        iD++;
        int rand = (int)((Math.random() * 8001) + 1000);
        userID = iD + "" + rand + SSN.substring(5);
        return userID;
    }

    // enroll() method
    public void enroll(String course) {
        this.courses += " " + course;
        System.out.println("You are now enrolled in: " + course);
        balance += courseCost;
    }

    // pay method
    public void pay(int amountToPay) {
        this.balance -= amountToPay;
        System.out.println("You have paid: $" + amountToPay + " toward your balance.");
    }

    // checkBalance method
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance + ".");
    }

    // toString method
    public String toString() {
        return "[Name: " + name + "]\n[Courses: " + courses + "]\n[Balance: $" + balance + "]";
    }

    // showCourses method
    public void showCourses() {
        System.out.println(courses);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
