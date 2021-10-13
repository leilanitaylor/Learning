package edXDataStructures.BasicDataStructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class process_packagesTest {

    process_packages packagesTest;
    @BeforeEach
    public void setUp() {packagesTest = new process_packages(); }

    @Test
    void testSample1ProcessRequests() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        ArrayList<Response> expected = new ArrayList<>();
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void testSample2ProcessRequests() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 0));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void testSample3ProcessRequests() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 1));
        requests.add(new Request(0, 1));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        expected.add(new Response(true, -1));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void testSample4ProcessRequests() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 1));
        requests.add(new Request(1, 1));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        expected.add(new Response(false, 1));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void test2ProcessRequests() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 0));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void test4ProcessRequest() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(1, 0));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 1));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void test6ProcessRequests() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 0));
        requests.add(new Request(0, 0));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        expected.add(new Response(false, 0));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void test11ProcessRequests() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 1));
        requests.add(new Request(2, 1));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        expected.add(new Response(false, 2));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void test12ProcessRequests() {
        Buffer buffer = new Buffer(2);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 1));
        requests.add(new Request(0, 1));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        expected.add(new Response(false, 1));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void test13ProcessRequests() {
        Buffer buffer = new Buffer(2);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 1));
        requests.add(new Request(0, 1));
        requests.add(new Request(0, 1));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        expected.add(new Response(false, 1));
        expected.add(new Response(true, -1));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void test14ProcessRequests() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 1));
        requests.add(new Request(1, 3));
        requests.add(new Request(4, 2));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        expected.add(new Response(false, 1));
        expected.add(new Response(false, 4));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void test15ProcessRequests() {
        Buffer buffer = new Buffer(1);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 2));
        requests.add(new Request(1, 4));
        requests.add(new Request(5, 3));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        expected.add(new Response(true, -1));
        expected.add(new Response(false, 5));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }

    @Test
    void test17ProcessRequests() {
        Buffer buffer = new Buffer(3);
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(0, 2));
        requests.add(new Request(1, 2));
        requests.add(new Request(2, 2));
        requests.add(new Request(3, 2));
        requests.add(new Request(4, 2));
        requests.add(new Request(5, 2));
        ArrayList<Response> expected = new ArrayList<>();
        expected.add(new Response(false, 0));
        expected.add(new Response(false, 2));
        expected.add(new Response(false, 4));
        expected.add(new Response(false, 6));
        expected.add(new Response(false, 8));
        expected.add(new Response(true, -1));
        ArrayList<Response> responses = process_packages.ProcessRequests(requests, buffer);
        Assertions.assertNotNull(responses);
        Assertions.assertEquals(expected.size(), responses.size());
        for (int i = 0; i < responses.size(); i++) {
            Assertions.assertEquals(expected.get(i).dropped, responses.get(i).dropped);
            Assertions.assertEquals(expected.get(i).start_time, responses.get(i).start_time);
        }
    }
}