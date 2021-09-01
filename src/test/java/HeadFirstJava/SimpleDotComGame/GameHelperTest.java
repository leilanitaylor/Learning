package HeadFirstJava.SimpleDotComGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameHelperTest {
    GameHelper helper1;
    @BeforeEach
    public void setup() {
        helper1 = new GameHelper();
    }


    @Test
    void getUserInputNullTest() {
        String prompt = "";
        String result = helper1.getUserInput(prompt);
        Assertions.assertNull(result);
    }

    @Test
    void getUserInputValidTest() {
        String prompt = "Test";
        String expected = "Test";
        String result = helper1.getUserInput(prompt);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }
}