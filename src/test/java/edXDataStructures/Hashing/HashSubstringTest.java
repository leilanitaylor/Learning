package edXDataStructures.Hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashSubstringTest {

    HashSubstring hs;
    @BeforeEach
    public void setUp() {hs = new HashSubstring(); }

    @Test
    void testSample1getOccurences() {
        String pattern = "aba";
        String text = "abacaba";
        HashSubstring.Data input = new HashSubstring.Data(pattern, text);
        List<Integer> expected = Arrays.asList(0, 4);
        List<Integer> result = new ArrayList<>();
        result = hs.getOccurences(input);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void testSample2getOccurences() {
        String pattern = "Test";
        String text = "testTesttesT";
        HashSubstring.Data input = new HashSubstring.Data(pattern, text);
        List<Integer> expected = Arrays.asList(4);
        List<Integer> result = new ArrayList<>();
        result = hs.getOccurences(input);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void testSample3getOccurences() {
        String pattern = "aaaaa";
        String text = "baaaaaaa";
        HashSubstring.Data input = new HashSubstring.Data(pattern, text);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> result = new ArrayList<>();
        result = hs.getOccurences(input);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void test1getOccurences() {
        String pattern = "lNoYhXmlwOscxnkTWjsyNJNhgvzMFbxFnbiWuBAGjZQlCRQHjTUX";
        String text = "ZtonpqnFzlpvUKZrBbRlNoYhXmlwOscxnkTWjsyNJNhgvzMFbxFnbiWuBAGjZQlCRQHjTUXxtHmTxoLuMbRYsvSpxhtrlvABBlFYmndFzHypOmJyFxjHEPlNoYhXmlwOscxnkTWjsyNJNhgvzMFbxFnbiWuBAGjZQlCRQHjTUXbDiEAvtPlNoYhXmlwOscxnkTWjsyNJNhgvzMFbxFnbiWuBAGjZQlCRQHjTUXRRNoBCUMQVOlNoYhXmlwOscxnkTWjsyNJNhgvzMFbxFnbiWuBAGjZQlCRQHjTUXRLKlNoYhXmlwOscxnkTWjsyNJNhgvzMFbxFnbiWuBAGjZQlCRQHjTUXAYPDKWtVpShhclNoYhXmlwOscxnkTWjsyNJNhgvzMFbxFnbiWuBAGjZQlCRQHjTUXOJlUlNoYhXmlwOscxnkTWjsyNJNhgvzMFbxFnbiWuBAGjZQlCRQHjTUXglmlNoYhXmlwOscxnkTWjsyNJNhgvzMFbxFnbiWuBAGjZQlCRQHjTUXuaOibGlVrwghvNTgLfltIbEdBlgjelFjQkBeFrdEV";
        HashSubstring.Data input = new HashSubstring.Data(pattern, text);
        List<Integer> expected = Arrays.asList(19, 118, 178, 241, 296, 361, 417, 472);
        List<Integer> result = new ArrayList<>();
        result = hs.getOccurences(input);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }
}