package AdventOfCode.AdventOfCode2020;
/*
Day 4:
    Part 1: Determine number of valid passports, required fields are: byr (birth year)
        iyr (Issue year), eyr (Expiration year), hgt (Height), hcl (Hair color),
        ecl (Eye color), pid (Passport ID)
    Part 2: Add validation for required fields:
            - byr (Birth Year) - four digits; at least 1920 and at most 2002
            - iyr (Issue Year) - four digits; at least 2010 adn at most 2020
            - eyr (Expiration Year) - four digits; at least 2020 adn at most 2030
            - htg (Height) - a number followed by either cm or in:
                - If cm, the number must be at least 150 and at most 193
                - if in, the number must be at least 59 and at most 76
            - hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f
            - ecl (Eye Color) - exactly one of: amb, blu, brn, gry, grn, hzl, oth
            - pid (Passport ID) - a nin-digit number, including leading zeroes
            - cid (Country ID) - ignored, missed or not
        Count passports where all required fields are both present and valid
 */

import edXDataStructures.Hashing.HashSubstring;

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
        if (!validByr(passportFields))
            return false;
        if (!validIyr(passportFields))
            return false;
        if (!validEyr(passportFields))
            return false;
        if (!validHgt(passportFields))
            return false;
        if (!validHcl(passportFields))
            return false;
        if (!validEcl(passportFields))
            return false;
        if (!validPid(passportFields))
            return false;
        return true;
    }

    protected static boolean validPid(Map<String, String> passportFields) {
        if (!passportFields.containsKey("pid"))
            return false;
        String passportId = passportFields.get("pid");
        if (passportId.length() != 9)
            return false;
        for (int i = 0; i < passportId.length(); i++) {
            if (!Character.isDigit(passportId.charAt(i)))
                return false;
        }
        return true;
    }

    protected static boolean validEcl(Map<String, String> passportFields) {
        if (!passportFields.containsKey("ecl"))
            return false;
        String eyeColor = passportFields.get("ecl");
        if (eyeColor.length() != 3)
            return false;
        HashSet<String> validColors = new HashSet<>();
        validColors.add("amb");
        validColors.add("blu");
        validColors.add("brn");
        validColors.add("gry");
        validColors.add("grn");
        validColors.add("hzl");
        validColors.add("oth");
        if(!validColors.contains(eyeColor))
            return false;
        return true;
    }

    protected static boolean validHcl(Map<String, String> passportFields) {
        if (!passportFields.containsKey("hcl"))
            return false;
        String hairColor = passportFields.get("hcl");
        if (hairColor.charAt(0) != '#')
            return false;
        if (hairColor.length() != 7)
            return false;
        HashSet<Character> validCharacters = new HashSet<>();
        validCharacters.add('0');
        validCharacters.add('1');
        validCharacters.add('2');
        validCharacters.add('3');
        validCharacters.add('4');
        validCharacters.add('5');
        validCharacters.add('6');
        validCharacters.add('7');
        validCharacters.add('8');
        validCharacters.add('9');
        validCharacters.add('a');
        validCharacters.add('b');
        validCharacters.add('c');
        validCharacters.add('d');
        validCharacters.add('e');
        validCharacters.add('f');
        for (int i = 1; i < hairColor.length(); i++) {
            if (!validCharacters.contains(hairColor.charAt(i)))
                return false;
        }
        return true;
    }

    protected static boolean validHgt(Map<String, String> passportFields) {
        if (!passportFields.containsKey("hgt"))
            return false;
        String hgt = passportFields.get("hgt");
        String hgtUnits = hgt.substring(hgt.length()-2);
        if (!hgtUnits.equals("in") && !hgtUnits.equals("cm"))
            return false;
        for (int i = 0; i < hgt.length() - 2; i++) {
            if (!Character.isDigit(hgt.charAt(i)))
                return false;
        }
        int height = Integer.parseInt(hgt.substring(0, hgt.length()-2));
        if (hgtUnits.equals("in")) {
            if (height < 59 || height > 76)
                return false;
        }
        if (hgtUnits.equals("cm")) {
            if (height < 150 || height > 193)
                return false;
        }
        return true;
    }

    protected static boolean validEyr(Map<String, String> passportFields) {
        if (!passportFields.containsKey("eyr"))
            return false;
        String eyr = passportFields.get("eyr");
        if (eyr.length() != 4)
            return false;
        for (int i = 0; i < eyr.length(); i++) {
            if (!Character.isDigit(eyr.charAt(i)))
                return false;
        }
        int expirationYear = Integer.parseInt(eyr);
        if (expirationYear < 2020 || expirationYear > 2030)
            return false;
        return true;
    }

    protected static boolean validIyr(Map<String, String> passportFields) {
        if (!passportFields.containsKey("iyr"))
            return false;
        String iyr = passportFields.get("iyr");
        if (iyr.length() != 4)
            return false;
        for (int i = 0; i < iyr.length(); i++){
            if (!Character.isDigit(iyr.charAt(i)))
                return false;
        }
        int issueYear = Integer.parseInt(iyr);
        if (issueYear < 2010 || issueYear > 2020)
            return false;
        return true;
    }

    protected static boolean validByr(Map<String, String> passportFields) {
        if (!passportFields.containsKey("byr"))
            return false;
        String byr = passportFields.get("byr");
        if (byr.length() != 4)
            return false;
        for (int i = 0; i < byr.length(); i++) {
            if (!Character.isDigit(byr.charAt(i)))
                return false;
        }
        int birthYear = Integer.parseInt(byr);
        if (birthYear < 1920 || birthYear > 2002)
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
