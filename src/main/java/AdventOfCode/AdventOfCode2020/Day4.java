package AdventOfCode.AdventOfCode2020;
/*
Day 4:
    Part 1: Determine number of valid passports, required fields are: byr (birth year)
        iyr (Issue year), eyr (Expiration year), hgt (Height), hcl (Hair color),
        ecl (Eye color), pid (Passport ID)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day4 {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> passportsFile = readFile();

        System.out.println(passportsFile.get(2).length());

        List<String> passports = setPassports(passportsFile);

        int validPasspots = countValid(passports);

        System.out.println("Valid Passports: " + validPasspots);
    }

    protected static int countValid(List<String> passports) {
        int count = 0;
        for (int i = 0; i < passports.size(); i++) {
            boolean isValid = checkValidity(passports.get(i));
            if (isValid) {
                count++;
            }
        }
        return count;
    }

    protected static boolean checkValidity(String passport) {
        Map<String, String> passportFields = generateFields(passport);

        boolean hasAllReqFields = checkFields(passportFields);

        return hasAllReqFields;
    }

    protected static boolean checkFields(Map<String, String> passportFields) {
        if (!passportFields.containsKey("byr"))
            return false;
        if (!passportFields.containsKey("iyr"))
            return false;
        if (!passportFields.containsKey("eyr"))
            return false;
        if (!passportFields.containsKey("hgt"))
            return false;
        if (!passportFields.containsKey("hcl"))
            return false;
        if (!passportFields.containsKey("ecl"))
            return false;
        if (!passportFields.containsKey("pid"))
            return false;
        return true;
    }

    protected static Map<String, String> generateFields(String passport) {
        Map<String, String> passportFields = new HashMap<>();
        char[] chars = passport.toCharArray();
        int index = 0;

        while (index < chars.length) {
            StringBuilder keySB = new StringBuilder();
            StringBuilder valueSB = new StringBuilder();

            while (chars[index] != ':') {
                keySB.append(chars[index]);
                index++;
            }
            index++;
            while (index < chars.length && chars[index] != ' ') {
                valueSB.append(chars[index]);
                index++;
            }
            String key = keySB.toString();
            String value = valueSB.toString();
            passportFields.put(key, value);

            index++;
        }

        return passportFields;
    }

    protected static List<String> setPassports(List<String> passportsFile) {
        List<String> passports = new ArrayList<>();
        for (int i = 0; i < passportsFile.size(); i++) {
            if (i + 1 < passportsFile.size() && passportsFile.get(i+1) != "" && passportsFile.get(i) != "") {
                passportsFile.set(i+1, combineStrings(passportsFile.get(i), passportsFile.get(i+1)));
            } else if (passportsFile.get(i) != "") {
                passports.add(passportsFile.get(i));
            }
        }
        return passports;
    }

    protected static String combineStrings(String string1, String string2) {
        StringBuilder combinedSB = new StringBuilder();
        combinedSB.append(string1);
        combinedSB.append(" ");
        combinedSB.append(string2);
        return combinedSB.toString();
    }

    private static List<String> readFile() throws FileNotFoundException {
        Path path = Paths.get("src/main/resources").resolve("Day4InputFile.txt");
        File fileOfPassports = path.toFile();
        List<String> passports = new ArrayList<>();

        Scanner sc = new Scanner(fileOfPassports);
        while (sc.hasNextLine()) {
            String passport = sc.nextLine();
            passports.add(passport);
        }
        return passports;
    }
}
