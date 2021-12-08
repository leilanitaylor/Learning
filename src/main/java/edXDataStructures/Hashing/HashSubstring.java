package edXDataStructures.Hashing;
/*
Problem: Find pattern in text
--------------------------------------------------------------------------------------
Problem Introduction:
In this problem, your goal is to implement the Rabin-Karp's algorithm.
--------------------------------------------------------------------------------------
Problem Description:
    Task: In this problem your goal is to implement the Rabin-Karp's algorithm for
        searching the given pattern in the given text.
    Input Format: There are two strings in the input: the pattern P and the text T.
    Constraints: 1 <= |P| <= |T| <= 5 * 10^5. The total length of all occurrences of
        P in T doesn't exceed 10^8. The pattern and the text contain only latin
        letters.
    Output Format: Print all the positions of the occurrences of P in T in the
        ascending order. Use 0-based indexing of positions in the text T.
    Time Limits: 5 sec.
    Memory Limit: 512 MB.

Sample 1:
    Input:
        aba
        abacaba
    Output:
        0 4
    Explanation: The pattern aba can be found in positions 0 and 4 of the text abacaba

Sample 2:
    Input:
        Test
        testTesttesT
    Output:
        4
    Explanation: Pattern and text are case-sensitive in this problem. Patter Test can
        only be found in position 4 in the text testTesttesT.

Sample 3:
    Input:
        aaaaa
        baaaaaaa
    Output:
        1 2 3
    Note that the occurences of the patter in teh text can be overlapping, and that's
        ok, you still need to output all of them.

Starter Files: The start solutions in C++, Java and Python 3 read the input, apply
the naive O(|T||P|) algorithm to this problem and write the output. You need to
implement the Rabin-Karp's algorithm instead of the naive algorithm and thus
significantly speed up the solution. If you use other languages, you need to implement
a solution from scratch.

What to Do: Implement the fast version of the Rabin-Karp's algorithm from the lectures.
Some hints based on teh problems encountered by learners;
    * Beware of integer overflow. Use long long type in C++ and long type in Java
      where appropriate. Take everything (mod p) as soon as possible while computing
      something (mod p), so that the numbers are always between 0 and p-1.
    * Beware of taking negative numbers (mod p). In many programming languages
      (-2) % 5 != 3 % 5. Thus you can compute the same hash values for two strings
      but when you compare them, they appear to be different. To avoid this issue,
      you can use such construct in the code: x <- ((a%p) + p) % p instead of just
      x <- a % p.
    * Use operator == in Python intead of implementing your own function AreEqual
      for strings, because built-in operator == will work much faster.
    * In C++, method substr of string creates a new string, uses additional memory
      and time for that, so use it carefully and avoid creating lots of new strings.
      When you need to compare pattern with a substring of text, do it without calling
      substr.
    * In Java, however, method substring does NOT create a new string. Avoid using
      new String where it is not needed, just use substring.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        //printOccurences(getOccurencesNaive(readInput()));
        printOccurences(getOccurences(readInput()));
        out.close();
    }

    protected static List<Integer> getOccurences(Data input) {
        String pattern = input.pattern;;
        String text = input.text;
        List<Integer> occurences = new ArrayList<>();
        String substringToCheck;

        HashSet<String> hashPattern = new HashSet<>();
        hashPattern.add(pattern);

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            substringToCheck = text.substring(i, i + pattern.length());
            if (hashPattern.contains(substringToCheck)) {
                occurences.add(i);
            }
        }
        return occurences;
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurencesNaive(Data input) {
        String s = input.pattern, t = input.text;
        int m = s.length(), n = t.length();
        List<Integer> occurences = new ArrayList<>();
        for (int i = 0; i + m <= n; ++i) {
            boolean equal = true;
            for (int j = 0; j < m; ++j) {
                if (s.charAt(j) != t.charAt(i + j)) {
                    equal = false;
                    break;
                }
            }
            if (equal)
                occurences.add(i);
        }
        return occurences;
    }

    static class Data {
        String pattern;
        String text;

        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
