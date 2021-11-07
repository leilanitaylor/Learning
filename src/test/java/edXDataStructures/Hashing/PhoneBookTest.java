package edXDataStructures.Hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    PhoneBook pb;
    @BeforeEach
    public void setUp() {pb = new PhoneBook(); }

    @Test
    void test1addNumber() {
        List<PhoneBook.Query> queries = new ArrayList<>();
        queries.add(new PhoneBook.Query("add", "police", 911));
        for (int i = 0; i < queries.size(); i++) {
            pb.addNumber(queries.get(i));
        }
        String[] expected = new String[10000000];
        expected[911] = "police";
        Assertions.assertNotNull(pb.phoneBook);
        for (int i = 0; i < pb.phoneBook.length; i++) {
            Assertions.assertEquals(expected[i], pb.phoneBook[i]);
        }
    }

    @Test
    void test2addNumber() {
        List<PhoneBook.Query> queries = new ArrayList<>();
        queries.add(new PhoneBook.Query("add", "police", 911));
        queries.add(new PhoneBook.Query("add", "Mom", 76213));
        queries.add(new PhoneBook.Query("add", "Bob", 17239));
        for (int i = 0; i < queries.size(); i++) {
            pb.addNumber(queries.get(i));
        }
        String[] expected = new String[10000000];
        expected[911] = "police";
        expected[76213] = "Mom";
        expected[17239] = "Bob";
        Assertions.assertNotNull(pb.phoneBook);
        for (int i = 0; i < pb.phoneBook.length; i++) {
            Assertions.assertEquals(expected[i], pb.phoneBook[i]);
        }
    }

    @Test
    void test3addNumber() {
        List<PhoneBook.Query> queries = new ArrayList<>();
        queries.add(new PhoneBook.Query("add", "police", 911));
        queries.add(new PhoneBook.Query("add", "Mom", 76213));
        queries.add(new PhoneBook.Query("add", "Bob", 17239));
        queries.add(new PhoneBook.Query("add", "daddy", 76213));
        for (int i = 0; i < queries.size(); i++) {
            pb.addNumber(queries.get(i));
        }
        String[] expected = new String[10000000];
        expected[911] = "police";
        expected[76213] = "daddy";
        expected[17239] = "Bob";
        Assertions.assertNotNull(pb.phoneBook);
        for (int i = 0; i < pb.phoneBook.length; i++) {
            Assertions.assertEquals(expected[i], pb.phoneBook[i]);
        }
    }

    @Test
    void test1deleteNumber() {
        List<PhoneBook.Query> queriesAdd = new ArrayList<>();
        queriesAdd.add(new PhoneBook.Query("add", "police", 911));
        queriesAdd.add(new PhoneBook.Query("add", "Mom", 76213));
        queriesAdd.add(new PhoneBook.Query("add", "Bob", 17239));
        for (int i = 0; i < queriesAdd.size(); i++) {
            pb.addNumber(queriesAdd.get(i));
        }
        List<PhoneBook.Query> queriesDelete = new ArrayList<>();
        queriesDelete.add(new PhoneBook.Query("del", 76213));
        for (int i = 0; i < queriesDelete.size(); i++) {
            pb.deleteNumber(queriesDelete.get((i)));
        }
        String[] expected = new String[10000000];
        expected[911] = "police";
        expected[17239] = "Bob";
        Assertions.assertNotNull(pb.phoneBook);
        for (int i = 0; i < pb.phoneBook.length; i++) {
            Assertions.assertEquals(expected[i], pb.phoneBook[i]);
        }
    }

    @Test
    void test1findNumber() {
        List<PhoneBook.Query> queries = new ArrayList<>();
        queries.add(new PhoneBook.Query("add", "police", 911));
        queries.add(new PhoneBook.Query("add", "Mom", 76213));
        queries.add(new PhoneBook.Query("add", "Bob", 17239));
        for (int i = 0; i < queries.size(); i++) {
            pb.addNumber(queries.get(i));
        }
        String expected = "police";
        String response = pb.findNumber(new PhoneBook.Query("find", 911));
        Assertions.assertNotNull(pb.phoneBook);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void test2findNumber() {
        List<PhoneBook.Query> queries = new ArrayList<>();
        queries.add(new PhoneBook.Query("add", "police", 911));
        queries.add(new PhoneBook.Query("add", "Mom", 76213));
        queries.add(new PhoneBook.Query("add", "Bob", 17239));
        for (int i = 0; i < queries.size(); i++) {
            pb.addNumber(queries.get(i));
        }
        String expected = "Mom";
        String response = pb.findNumber(new PhoneBook.Query("find", 76213));
        Assertions.assertNotNull(pb.phoneBook);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void test3findNumber() {
        List<PhoneBook.Query> queries = new ArrayList<>();
        queries.add(new PhoneBook.Query("add", "police", 911));
        queries.add(new PhoneBook.Query("add", "Mom", 76213));
        queries.add(new PhoneBook.Query("add", "Bob", 17239));
        queries.add(new PhoneBook.Query("add", "daddy", 76213));
        for (int i = 0; i < queries.size(); i++) {
            pb.addNumber(queries.get(i));
        }
        String expected = "daddy";
        String response = pb.findNumber(new PhoneBook.Query("find", 76213));
        Assertions.assertNotNull(pb.phoneBook);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testSample1procQuery() {
        List<PhoneBook.Query> queries = new ArrayList<>();
        queries.add(new PhoneBook.Query("add", "police", 911));
        queries.add(new PhoneBook.Query("add", "Mom", 76213));
        queries.add(new PhoneBook.Query("add", "Bob", 17239));
        queries.add(new PhoneBook.Query("find", 76213));
        queries.add(new PhoneBook.Query("find", 910));
        queries.add(new PhoneBook.Query("find", 911));
        queries.add(new PhoneBook.Query("del", 910));
        queries.add(new PhoneBook.Query("del", 911));
        queries.add(new PhoneBook.Query("find", 911));
        queries.add(new PhoneBook.Query("find", 76213));
        queries.add(new PhoneBook.Query("add", "daddy", 76213));
        queries.add(new PhoneBook.Query("find", 76213));
        for (int i = 0; i < queries.size(); i ++) {
            pb.procQuery(queries.get(i));;
        }
        String[] expected = {"Mom", "not found", "police", "not found", "Mom", "daddy"};
        Assertions.assertNotNull(pb.phoneBook);
        Assertions.assertEquals(expected.length, pb.responses.size());
        for (int i = 0; i < expected.length; i ++) {
            Assertions.assertEquals(expected[i], pb.responses.get(i));
        }
    }

    @Test
    void testSample2procQuery() {
        List<PhoneBook.Query> queries = new ArrayList<>();
        queries.add(new PhoneBook.Query("find", 3839442));
        queries.add(new PhoneBook.Query("add", "me", 123456));
        queries.add(new PhoneBook.Query("add", "granny", 0));
        queries.add(new PhoneBook.Query("find", 0));
        queries.add(new PhoneBook.Query("find", 123456));
        queries.add(new PhoneBook.Query("del", 0));
        queries.add(new PhoneBook.Query("del", 0));
        queries.add(new PhoneBook.Query("find", 0));
        for (int i = 0; i < queries.size(); i ++) {
            pb.procQuery(queries.get(i));;
        }
        String[] expected = {"not found", "granny", "me", "not found"};
        Assertions.assertNotNull(pb.phoneBook);
        Assertions.assertEquals(expected.length, pb.responses.size());
        for (int i = 0; i < expected.length; i ++) {
            Assertions.assertEquals(expected[i], pb.responses.get(i));
        }
    }
}