package AdventOfCode.AdventOfCode2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


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

    @Test
    void test1validByr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2013");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1920");
        boolean expected = true;
        boolean result = d4.validByr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2validByr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2013");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1919");
        boolean expected = false;
        boolean result = d4.validByr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3validByr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2013");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "2002");
        boolean expected = true;
        boolean result = d4.validByr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4validByr()  {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2013");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "2003");
        boolean expected = false;
        boolean result = d4.validByr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5validByr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2013");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "abcd");
        boolean expected = false;
        boolean result = d4.validByr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6validByr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2013");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "193O");
        boolean expected = false;
        boolean result = d4.validByr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test7validByr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2013");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        boolean expected = false;
        boolean result = d4.validByr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1validIyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2010");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = true;
        boolean result = d4.validIyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2validIyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validIyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3validIyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2020");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = true;
        boolean result = d4.validIyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4validIyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2021");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validIyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5validIyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "02019");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validIyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6validIyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "202O");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validIyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test7validIyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2023");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validIyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1validEyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = true;
        boolean result = d4.validEyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2validEyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2019");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validEyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3validEyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2030");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = true;
        boolean result = d4.validEyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4validEyer() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2031");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validEyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5validEyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "02020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validEyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6validEyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "202O");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validEyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test7validEyr() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        boolean expected = false;
        boolean result = d4.validEyr(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "58in");
        boolean expected = false;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "76in");
        boolean expected = true;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "77in");
        boolean expected = false;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "150cm");
        boolean expected = true;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "149cm");
        boolean expected = false;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test7validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "193cm");
        boolean expected = true;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test8validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "194cm");
        boolean expected = false;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test9validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "190");
        boolean expected = false;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test10validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "60ab");
        boolean expected = false;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test11validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test12validHgt() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "6Oin");
        boolean expected = false;
        boolean result = d4.validHgt(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1validHcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#cfa07d");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validHcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2validHcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validHcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3validHcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abz");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validHcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4validHcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validHcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5validHcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123ab");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validHcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6validHcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validHcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1validEcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void  test2validEcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "blu");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3validEcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "brn");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4validEcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "gry");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5validEcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "grn");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6validEcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "hzl");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test7validEcl(){
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "oth");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test8validEcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "blue");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test9validEcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "0th");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test10validEcl() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validEcl(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1validPid() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "028048840");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validPid(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2validPid() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "000000001");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = true;
        boolean result = d4.validPid(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3validPid() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "0123456789");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validPid(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4validPid() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "02804884");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validPid(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5validPid() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("pid", "000000O01");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validPid(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6validPid() {
        Map<String, String> fields = new HashMap<>();
        fields.put("iyr", "2009");
        fields.put("ecl", "amb");
        fields.put("cid", "350");
        fields.put("eyr", "2020");
        fields.put("hcl", "#123abc");
        fields.put("byr", "1929");
        fields.put("hgt", "59in");
        boolean expected = false;
        boolean result = d4.validPid(fields);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2checkValidity() {
        String passport = "eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926";
        boolean expected = false;
        boolean result = d4.checkValidity(passport);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3checkValidity() {
        String passport = "hcl:dab227 iyr:2012 ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277";
        boolean expected = false;
        boolean result = d4.checkValidity(passport);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4checkValidity() {
        String passport = "hgt:59cm ecl:zzz eyr:2038 hcl:74454a iyr:2023 pid:3556412378 byr:2007";
        boolean expected = false;
        boolean result = d4.checkValidity(passport);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test5checkValidity() {
        String passport = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f";
        boolean expected = true;
        boolean result = d4.checkValidity(passport);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test6checkValidity() {
        String passport = "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm";
        boolean expected = true;
        boolean result = d4.checkValidity(passport);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test7checkValidity() {
        String passport = "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2022";
        boolean expected = true;
        boolean result = d4.checkValidity(passport);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test8checkValidity() {
        String passport  = "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719";
        boolean expected = true;
        boolean result = d4.checkValidity(passport);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2countValid() {
        List<String> passports = new ArrayList<>();
        passports.add("eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926");
        passports.add("hcl:dab227 iyr:2012 ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277");
        passports.add("hgt:59cm ecl:zzz eyr:2038 hcl:74454a iyr:2023 pid:3556412378 byr:2007");
        passports.add("pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f");
        passports.add("eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm");
        passports.add("hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2022");
        passports.add("iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719");
        int expected = 4;
        int result = d4.countValid(passports);
    }
}