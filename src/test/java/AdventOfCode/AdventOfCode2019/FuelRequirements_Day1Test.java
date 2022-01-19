package AdventOfCode.AdventOfCode2019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FuelRequirements_Day1Test {

    FuelRequirements_Day1 d1;
    @BeforeEach
    public void setUp() {d1 = new FuelRequirements_Day1(); }

    @Test
    void test1fuelForCurrModule() {
        Integer module = 12;
        int expected = 2;
        int result = d1.fuelForCurrModule(module);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test2fuelForCurrModule() {
        Integer module = 14;
        int expected = 2;
        int result = d1.fuelForCurrModule(module);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test3fuelForCurrModule() {
        Integer module = 1969;
        int expected = 654;
        int result = d1.fuelForCurrModule(module);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test4fuelForCurrModule() {
        Integer module = 100756;
        int expected = 33583;
        int result = d1.fuelForCurrModule(module);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test1findTotal() {
        List<Integer> modules = Arrays.asList(12, 14, 1969, 100756);
        int expected = 34241;
        int result = d1.findTotal(modules);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }
}