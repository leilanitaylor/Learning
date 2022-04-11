package HackerRank;

public class SuperDigit {
    public static void main(String[] args) {
        String n = "9875";
        int k = 4;

        int superD = superDigit(n, k);

        System.out.println(superD);
    }

    public static int superDigit(String n, int k) {
        // Write your code here
        String numberConcatenatedString = "";

        for (int i = 0; i < k; i++)
            numberConcatenatedString += n;

        long numberConcatenated = Long.parseLong(numberConcatenatedString);

        long supDigit = findSuperDigit(numberConcatenated);

        return (int)supDigit;
    }

    public static long findSuperDigit(long number) {
        if (number / 10 == 0)
            return number;

        long newNumber = 0;

        while (number / 10 > 0) {
            newNumber += number % 10;
            number = number / 10;
        }

        newNumber += number;

        return findSuperDigit(newNumber);
    }
}
