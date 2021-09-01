package HeadFirstJava.DotComGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class DotComTest {
    DotCom dotCom1;
    @BeforeEach
    public void setUp() {
        dotCom1 = new DotCom();
    }

    @Test
    void testCheckYourselfHit() {
        ArrayList<String> locCells = new ArrayList<String>(Arrays.asList("a0", "a1", "a2"));
        dotCom1.setLocationCells(locCells);
        String guess = "a0";
        String expected = "hit";
        String result = dotCom1.checkYourself(guess);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
        expected = "miss";
        result = dotCom1.checkYourself(guess);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckYourselfMiss() {
        ArrayList<String> locCells = new ArrayList<String>(Arrays.asList("a0", "a1", "a2"));
        dotCom1.setLocationCells(locCells);
        String guess = "b3";
        String expected = "miss";
        String result = dotCom1.checkYourself(guess);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCheckYourselfKill() {
        ArrayList<String> locCells = new ArrayList<String>(Arrays.asList("a2"));
        dotCom1.setLocationCells(locCells);
        String guess = "a2";
        String expected = "kill";
        String result = dotCom1.checkYourself(guess);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }
}