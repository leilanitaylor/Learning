package juniorJavaDevClass.Labs.StudentDatabaseSolution;

import java.util.Locale;

public class Lab2 {
    public static void main(String[] args) {
        // Create a Student
        Student stu1 = new Student("Janelle", "321456987");
        Student stu2 = new Student("Thomas", "456879546");
        Student stu3 = new Student("Elizabeth", "615326574");

        stu1.enroll("Math151");
        stu1.enroll("Eng255");
        stu1.enroll("His211");

        //stu1.showCourses();
        //stu1.checkBalance();
        stu1.payTuition(600);
        //stu1.checkBalance();
        System.out.println(stu1.toString());
    }
}

class Student {
    // Properties
    private static int iD = 0;
    private String userId;
    private String name;
    private String ssn;
    private String email;
    private String phone;
    private String city;
    private String state;
    private String courses = "";
    private static final int costOfCourse = 800;
    private int balance = 0;

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

    public Student(String name, String ssn) {
        iD++;
        this.name = name;
        this.ssn = ssn;
        setUserId();
        setEmail();
    }



    private void setEmail() {
        email = name.toLowerCase() + "." + iD + "@sdetuniversity.com";
        System.out.println("Your email: " + email);
    }

    public String getEmail() {
        return email;
    }

    private void setUserId() {
        int max = 9000;
        int min = 1000;
        int randNum = (int) ((Math.random() * (max - min)));
        randNum = randNum + min;
        userId = iD + "" + randNum + ssn.substring(5);
        System.out.println("Your user ID: " +userId);
    }

    public void enroll(String course) {
        this.courses = this.courses + "\t" + course;
        System.out.println(courses);
        balance = balance + costOfCourse;
    }

    public void payTuition(int amount) {
        balance = balance - amount;
        System.out.println("Payment: $" + amount);
    }

    public void checkBalance() {
        System.out.println("Balance: $" + balance);
    }

    public void showCourses() {
        System.out.println(courses);
    }

    public String toString() {
        return "[Name: " + name + " ]\n[COURSES: " + courses + " ]\nBALANCE: " + balance + " ]";
    }
}