package edXDataStructures.Hashing;
/*
Problem: Phone book
--------------------------------------------------------------------------------------
Problem Introduction
    In this problem you will implement a simple phone book manager.
--------------------------------------------------------------------------------------
Problem Description:
    Task: In this task your goal is to implement a simple phone book manager. It
        should be able to process the following types of user's queries:
            * add number name. It means that the user adds a person with name 'name'
              and phone number 'number' to the phone book. If there already exists a
              user with such number already, then your manager has to overwrite the
              corresponding name.
            * del number. It means that the manager should erase a person with number
              'number' from the phone book. If there is no such person, then it should
              just ignore the query.
            * find number. It means that the user looks for a person with phone number
              'number'. The manager should reply with the appropriate name, or with
              string "not found" (without quotes) if there is no such person in the
              book.
    Input Format: There is a single integer N in the first line - the number of
        queries. It's followed by N lines, each of the contains one query in the
        format described above.
    Constraints: 1 <= N <= 10^5. All phone numbers consist of decimal digits, they
        don't have leading zeros, and each of them has no more than 7 digits. All
        names are non-empty strings of latin letters, and each of them has length
        at most 15. It's guaranteed that there is no person with name "not found".
    Output Format: Print the result of each 'find' query - the name corresponding to
        the phone number or "not found" (without quotes) if there is no person in the
        phone book with such phone number. Output one result per line in the same
        order as the 'find' queries given in the input.
    Time Limits: 6 sec.
    Memory Limit: 512 MB.

Sample 1:
    Input:
        12
        add 911 police
        add 76213 Mom
        add 17239 Bob
        find 76213
        find 910
        find 911
        del 910
        del 911
        find 911
        find 76213
        add 76213 daddy
        find 76213
    Output:
        Mom
        not found
        police
        not found
        Mom
        daddy
    Explanation: 76213 is Mom's number, 910 is not a number in the phone book, 911
        is the number of police, but then it ws deleted from the phone book, so the
        second search for 911 returned "not found". Also, note that when the daddy
        was added with the same phone number 76213 as Mom's phone number, the
        contact's name was re-written, and now search for 76213 returns "daddy"
        instead of "Mom".

Sample 2:
    Input:
        8
        find 3839442
        add 123456 me
        add 0 granny
        find 0
        find 123456
        del 0
        del 0
        find 0
    Output:
        not found
        granny
        me
        not found
    Explanation: Recall that deleting a number that doesn't exist in the phone book
        doesn't change anything.

Starter Files: The starter solutions for C++, Java, and Python3 in this problem read
    the input, implement a naive algorithm to look up names by phone numbers and
    write the output. You need to use a fast data structure to implement a better
    algorithm. If you use other languages, you need to implement the solution from
    scratch

What to Do: Use the direct addressing scheme.
 */

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class PhoneBook {

    private FastScanner in = new FastScanner();
    // Keep list of all existing (i.e. not deleted yet) contacts.
    private List<Contact> contacts = new ArrayList<>();
    public String[] phoneBook = new String[10000000];
    //public List<String> responses = new ArrayList<>();

    public static void main(String[] args) {
        //new PhoneBook().processQueries();
        new PhoneBook().process();
    }

    private void process() {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            procQuery(readQuery());
    }

    public void procQuery(Query query) {
        if (query.type.equals("add")) {
            addNumber(query);
        } else if (query.type.equals("del")) {
            deleteNumber(query);
        } else {
            writeResponse(findNumber(query));
            //responses.add(findNumber(query));
        }
    }

    public String findNumber(Query query) {
        String response = phoneBook[query.number];
        if (response == null) {
            response = "not found";
        }
        return response;
    }

    public void deleteNumber(Query query) {
        phoneBook[query.number] = null;
    }

    public void addNumber(Query query) {
        phoneBook[query.number] = query.name;
    }

    private Query readQuery() {
        String type = in.next();
        int number = in.nextInt();
        if (type.equals("add")) {
            String name = in.next();
            return new Query(type, name, number);
        } else {
            return new Query (type, number);
        }
    }

    private void writeResponse(String response) {
        System.out.println(response);
    }

    private void processQuery(Query query) {
        if (query.type.equals("add")) {
            // if we already have contact with such number,
            // we should rewrite contact's name
            boolean wasFound = false;
            for (Contact contact : contacts)
                if (contact.number == query.number) {
                    contact.name = query.name;
                    wasFound = true;
                    break;
                }
            // otherwise, just add it
            if (!wasFound)
                contacts.add(new Contact(query.name, query.number));
        } else if (query.type.equals("del")) {
            for (Iterator<Contact> it = contacts.iterator(); it.hasNext(); )
                if (it.next().number == query.number) {
                    it.remove();
                    break;
                }
        } else {
            String response = "not found";
            for (Contact contact : contacts)
                if (contact.number == query.number) {
                    response = contact.name;
                    break;
                }
            writeResponse(response);
        }
    }

    public void processQueries() {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery(readQuery());
    }

    static class Contact {
        String name;
        int number;

        public Contact (String name, int number) {
            this.name = name;
            this.number = number;
        }
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
