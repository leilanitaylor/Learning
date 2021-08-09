package main.juniorJavaDevClass.basics;

public class SalaryCalculator {
    public static void main(String[] args) {
        // Let's create a variable to define our career

        // delcare a variable
        String career;
        System.out.println("Program is starting");

        // define a variable
        career = "Software Developer";
        System.out.println("My career is: " + career);

        // delcare and define
        int hoursPerWeek = 40;
        int weeksPerYear = 50;
        double rate = 42.50;
        career = "Web Developer";

        double salary = hoursPerWeek * weeksPerYear * weeksPerYear * rate;
        System.out.println("My salary as a " + career + "at the rate of $" + rate + " per hour is $" + salary + " per year.");

        // compute our annual salary
        // rate * hoursPerWeek * weeksPerYear
    }
}
