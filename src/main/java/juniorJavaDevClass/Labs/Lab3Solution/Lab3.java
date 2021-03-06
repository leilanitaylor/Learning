package juniorJavaDevClass.Labs.Lab3Solution;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class Lab3 {

    public static void main(String[] args) {
        // Read a file of passwords
        Path path = Paths.get("src/main/resources").resolve("Passwords.txt");
        String[] passwords = new String[14];

        File file = path.toFile();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (int i = 0; i < passwords.length; i++) {
                passwords[i] = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Could not open file");
        } catch (IOException e) {
            System.out.println("ERROR: could not read file");
        }

        // Test against our criteria
        for (String password : passwords) {
            System.out.print("*****\n" + password + "\n");
            boolean hasNumber = false;
            boolean hasLetter = false;
            boolean hasSpecialChar = false;
            boolean hasInvalidChar = false;

            for (int n = 0; n < password.length(); n++) {
                // Condition 1: contains number
                if ("0123456789".contains(password.substring(n, n+1))) {
                    hasNumber = true;
                    //System.out.println("Position " + n + " contains a number");
                }
                // Condition 2: contains letter
                else if ("abcdefghijklmnopqrstuvwxyz".contains(password.substring(n, n+1).toLowerCase(Locale.ROOT))) {
                    hasLetter = true;
                    //System.out.println("Position " + n + " contains a letter");
                }
                // Condition 3: contains special character: ! @ # $
                else if ("!@#$%^&*()-_+=".contains(password.substring(n, n+1))) {
                    hasSpecialChar = true;
                    //System.out.println("Position " + n + " contains a special character");
                }
                else {
                    hasInvalidChar = true;
                    try {
                        throw new InvalidCharacterException(password.substring(n, n+1));
                    } catch (InvalidCharacterException e) {
                        System.out.println(e.toString());
                    }
                    //System.out.println("Position " + n + " has invalid character");
                }

            }

            // Test & Exception Handling
            try {
                if (!hasNumber) {throw new NumberCriteriaException(password);}
                else if (!hasLetter) { throw new LetterCriteriaException(password);}
                else if (!hasSpecialChar) { throw new SpecialCharCriteriaException(password);}
                else {System.out.println("Valid password");}
            } catch (NumberCriteriaException | LetterCriteriaException | SpecialCharCriteriaException e) {
                System.out.println("Invalid password");
                System.out.println(e.toString());
            }
        }
    }
}


class InvalidCharacterException extends Exception {
    String ch;
    public InvalidCharacterException(String ch) {
        this.ch = ch;
    }
    public String toString() {
        return "InvalidCharacterException: " + ch;
    }
}

class NumberCriteriaException extends Exception {
    String password;
    public NumberCriteriaException(String password) {
        this.password = password;
    }
    public String toString() {
        return "NumberCriteriaException: " + password;
    }
}


class LetterCriteriaException extends Exception {
    String password;
    public LetterCriteriaException(String password) {
        this.password = password;
    }
    public String toString() {
        return "LetterCriteriaException: " + password;
    }
}


class SpecialCharCriteriaException extends Exception {
    String password;
    public SpecialCharCriteriaException(String password) {
        this.password = password;
    }
    public String toString() {
        return "SpecialCharCriteriaException: " + password;
    }
}