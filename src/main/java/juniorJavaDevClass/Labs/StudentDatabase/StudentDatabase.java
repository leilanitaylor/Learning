package juniorJavaDevClass.Labs.StudentDatabase;

/*
Lab 2 - Object-Oriented Programming
Create a student Database with the following attributes:
    - New Student constructor that takes name and SSN in the arguments
    - Automatically create an email ID based on teh name
    - Set a private static ID
    - Generate a user ID that is combination fo Static ID, random 4-digit number between 1000 and 9000, and the last 4 of SSN
    - Methods: enroll(), pay(), checkBalance(), toString(), showCourses()
    use encapsulation to set variables (phone, city, state)
 */

public class StudentDatabase {
    public static void main(String[] args) {
        Student student1 = new Student("Paul", "546581535");
        Student student2 = new Student("Susan", "315549585");
        Student student3 = new Student("John", "645354685");

        student1.enroll("HIST101");
        student1.enroll("MATH102");
        student1.enroll("ENGL105");
        student1.checkBalance();
        student1.pay(1000);
        student1.checkBalance();
        System.out.println(student1.toString());
    }
}
