package AdventOfCode.AdventOfCode2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Day4Test {

    Day4 d4;
    @BeforeEach
    public void setUp() {d4 = new Day4(); }

    @Test
    void test1combineStrings() {
        String string1 = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd";
        String string2 = "byr:1937 iyr:2017 cid:147 hgt:183cm";
        String expected = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";
        String result = d4.combineStrings(string1, string2);
        Assertions.assertEquals(expected.length(), result.length());
        for (int i = 0; i < expected.length(); i++) {
            Assertions.assertEquals(expected.charAt(i), result.charAt(i));
        }
    }

    @Test
    void test1setPassports() {
        List<String> passportsFile = new ArrayList<>();
        passportsFile.add("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd");
        passportsFile.add("byr:1937 iyr:2017 cid:147 hgt:183cm");
        passportsFile.add("");
        passportsFile.add("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884");
        passportsFile.add("hcl:#cfa07d byr:1929");
        passportsFile.add("");
        passportsFile.add("hcl:#ae17e1 iyr:2013");
        passportsFile.add("eyr:2024");
        passportsFile.add("ecl:brn pid:760753108 byr:1931");
        passportsFile.add("hgt:179cm");
        passportsFile.add("");
        passportsFile.add("hcl:#cfa07d eyr:2025 pid:166559648");
        passportsFile.add("iyr:2011 ecl:brn hgt:59in");
        List<String> expected = new ArrayList<>();
        expected.add("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm");
        expected.add("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929");
        expected.add("hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm");
        expected.add("hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in");
        List<String> result = d4.setPassports(passportsFile);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            for (int j = 0; j < expected.get(i).length(); j++) {
                Assertions.assertEquals(expected.get(i).charAt(j), result.get(i).charAt(j));
            }
        }
    }

    @Test
    void test1generateFields() {
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";
        Map<String, String> expected = new HashMap<>();
        expected.put("ecl", "gry");
        expected.put("pid", "860033327");
        expected.put("eyr", "2020");
        expected.put("hcl", "#fffffd");
        expected.put("byr", "1937");
        expected.put("iyr", "2017");
        expected.put("cid", "147");
        expected.put("hgt", "183cm");
        Map<String,String> result = d4.generateFields(passport);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (Map.Entry<String, String> entry : expected.entrySet()) {
            Assertions.assertTrue(result.containsKey(entry.getKey()));
        }
    }

    @Test
    void test1checkFields() {
        Map<String, String> fields = new HashMap<>();
        fields.put("ecl", "gry");
        fields.put("pid", "860033327");
        fields.put("eyr", "2020");
        fields.put("hcl", "#fffffd");
        fields.put("byr", "1937");
        fields.put("iyr", "2017");
        fields.put("cid", "147");
        fields.put("hgt", "183cm");
        boolean expected = true;
        boolean result = d4.checkFields(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2checkFields() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2013");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.checkFields(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1countValid() {
        List<String> passports = new ArrayList<>();
        passports.add("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm");
        passports.add("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929");
        passports.add("hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm");
        passports.add("hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in");
        int expected = 2;
        int result = d4.countValid(passports);
        Assertions.assertEquals(expected, result);
    }
}