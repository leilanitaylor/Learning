package main.juniorJavaDevClass.basics;

public class NumbersCalc {

    public static void main(String[] args) {
        System.out.println("System is starting");
        printName();
        int numA = 10;
        int numB = 20;
        addNumbers(numA, numB);
        System.out.println("The product of " + numA + " and " + numB + " is " + multipleNumbers(numA, numB));
    }

    static void printName() {
        System.out.println("My name is Tim");
    }

    static void addNumbers(int numberA, int numberB) {
        // this function will add two numbers
        int sum = numberA + numberB;
        System.out.println(" The sum of numbers " + numberA + " and " + numberB + " is " + sum);
    }

    static int multipleNumbers(int valueA, int valueB) {
        int product = valueA * valueB;
        addNumbers(product, product);
        return product;
    }


}
