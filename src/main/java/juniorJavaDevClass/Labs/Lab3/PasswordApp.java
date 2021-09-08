package juniorJavaDevClass.Labs.Lab3;
/*
Questions for this assignment
Read a file that checks the criteria for a password
    1. Read a file that contains multiple sets of passwords (use http://www.theonegenerator.com/ to generate a set of test data)
    2. Verify that the password contains all fo the following criteria:
        1. A number
        2. A letter
        3. Special character (! @ #)
    3. Create three User Defined Exceptions for the corresponding criteria.
    4. If the password does not meet the criteria, create and throw the appropriate exception
 */


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PasswordApp {
    public static void main(String[] args) {

        Path path = Paths.get("src/main/resources").resolve("Passwords.txt");
        File file = path.toFile();
        ArrayList<String> passwords = new ArrayList<>();
        String password;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                passwords.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR: Could not read file.");
            e.printStackTrace();
        }

        for (int i = 0; i < passwords.size(); i++) {
            password = passwords.get(i);
            boolean containsLetter = false;
            boolean containsNumber = false;
            boolean containsSpecialChar = false;
            try {
                for (int j = 0; j < password.length(); j++) {
                    if (Character.isLetter(password.charAt(j))) {
                        containsLetter = true;
                        break;
                    }
                }
                if (!containsLetter) throw new NoLetterException(password);
                for (int j = 0; j < password.length(); j++) {
                    if (Character.isDigit(password.charAt(j))) {
                        containsNumber = true;
                        break;
                    }
                }
                if (!containsNumber) throw new NoNumberException(password);
                for (int j = 0; j < password.length(); j++) {
                    if (password.charAt(j) == '!' || password.charAt(j) == '@' || password.charAt(j) == '#') {
                        containsSpecialChar = true;
                        break;
                    }
                }
                if (!containsSpecialChar) throw new NoSpecialCharacterException(password);
                System.out.println("Password approved: " + password);
            } catch (NoLetterException e) {
                System.out.println("ERROR: Invalid password.");
                System.out.println(e.toString());
            }
            catch (NoNumberException e) {
                System.out.println("ERROR: Invalid password.");
                System.out.println(e.toString());
            } catch (NoSpecialCharacterException e) {
                System.out.println("ERROR: Invalid password.");
                System.out.println(e.toString());
            }
        }
    }
}
