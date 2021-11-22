package AdventOfCode.AdventOfCode2020;
/*
Day 2:
    Part 1: Each line gives a password policy and then the password. The password
        policy indicates the lowest and highest number of times a given letter must
        appear for the password to be valid. For example, '1-3 a' means that the
        password must contain 'a' at least 1 time and at most 3 times. How many
        passwords are valid according to their policies?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {

        List<pwPolicy> passwords = readFile();

        int numValid = countValid(passwords);

        System.out.println("Number of valid passwords: " + numValid);
    }

    protected static int countValid(List<pwPolicy> passwords) {
        int count = 0;

        for (int i = 0; i < passwords.size(); i++) {
            boolean isValid = testValidity(passwords.get(i));
            if (isValid) {
                count++;
            }
        }

        return count;
    }

    protected static boolean testValidity(pwPolicy pwPolicy) {
        int reqCharCount = 0;
        String password = pwPolicy.password;
        char reqChar = pwPolicy.reqChar;
        int minOcc = pwPolicy.minOcc;
        int maxOcc = pwPolicy.maxOcc;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == reqChar) {
                reqCharCount++;
                if (reqCharCount > maxOcc) {
                    return false;
                }
            }
        }
        if (reqCharCount < minOcc) {
            return false;
        }
        return true;
    }

    private static List<pwPolicy> readFile() throws FileNotFoundException {
        Path path = Paths.get("src/main/resources").resolve("Day2InputFile.txt");
        File passwordPolicies = path.toFile();
        List<pwPolicy> passwords = new ArrayList<>();

        Scanner sc = new Scanner(passwordPolicies);
        while (sc.hasNextLine()) {
            String policyPassword = sc.nextLine();
            char[] chars = policyPassword.toCharArray();
            StringBuilder minOccString = new StringBuilder();
            StringBuilder maxOccString = new StringBuilder();
            int index = 0;
            for (int i = 0; i < policyPassword.length(); i++) {
                if(!Character.isDigit(chars[i])) {
                    break;
                }
                minOccString.append(chars[i]);
                index++;
            }
            int minOcc = Integer.parseInt(minOccString.toString());
            index++;
            for (int i = index; i < policyPassword.length(); i++) {
                if(!Character.isDigit(chars[i])) {
                    break;
                }
                maxOccString.append(chars[i]);
                index++;
            }
            int maxOcc = Integer.parseInt(maxOccString.toString());
            index++;
            char reqChar = policyPassword.charAt(index);
            String password = policyPassword.substring(index + 3, policyPassword.length());
            passwords.add(new pwPolicy(minOcc, maxOcc, reqChar, password));
        }
        return passwords;
    }

    static class pwPolicy {
        int minOcc;
        int maxOcc;
        char reqChar;
        String password;

        public pwPolicy(int minOcc, int maxOcc, char reqChar, String password) {
            this.minOcc = minOcc;
            this.maxOcc = maxOcc;
            this.reqChar = reqChar;
            this.password = password;
        }
    }
}
