package edXDataStructures.BasicDataStructures;
/*
Problem: Check Brackets in the code
--------------------------------------------------------------------------------------------
Problem Introduction:
In this problem you will implement a feature for a text editor to find errors int eh usage
of brackets in the code.
--------------------------------------------------------------------------------------------
Problem Description:
    Task: Your friend is making a text editor for programmers. He is currently working on
        a feature that will find errors in the usage of different types of brackets. Code
        can contain any brackets from the set [] {} (), where the opening brackets are
        [, {, ( and the closing brackets corresponding to them are ], }, and )
        For convenience, the text editor should not only inform the user that there is an
        error in teh usage of brackets, but also point to the exact place in the code with
        the problematic bracket. First priority is to find the first unmatched closing
        bracket which either doesn't have an opening bracket before it, lik ] in ](), or
        closes the wrong opening bracket, li } in ()[}. If there are no such mistakes,
        then it should find the first unmatched opening bracket without the corresponding
        closing bracket after it, like ( in {}([]. If there are no mistakes, text editor
        should inform the user that the usage of brackets is correct.
        Apart from the brackets, code can contain bing and small latin letters, digits,
        and punctuation marks.
        More formally, all brackets in the code should be divided into pairs of matching
        brackets, such that in each pari the opening bracket goes before the closing
        bracket, and for any two pairs of brackets either one of them is nested inside
        another one as in (foo[bar]) or they are separate as in f(a,b)-g[c]. The bracket
        [ corresponds to the bracket ], { corresponds to }, and ( corresponds to ).
    Input Format: Input contains one string S which consists of bing and small latin
        letters, digits, punctuation marks and brackets from the set [] {} ().
    Constraints: The length of S is at least 1 and at most 10^5.
    Output Format: If the code in S uses brackets correctly, output "Success" (without
        the quotes). Otherwise, output the 1-based index of the first unmatched closing
        bracket, and if there are no unmatched closing brackets, output the 1-based index
        of the first unmatched opening bracket.
    Time Limits: 1 sec
    Memory Limit: 512 MB

Sample 1:
    Input:
        []
    Output:
        Success
    The brackets are used correctly: there is just one pair of brackets [ and ], they
    correspond to ech other, the left bracket [ goes before the right bracket], and no two
    pairs of brackets intersect, because there is just one pair of brackets.

Sample 2:
    Input:
        {}[]
    Output:
        Success
    The brackets are used correctly: there are two pairs of brackets - first pair of { and
    }, and second pair of [ and ] - and these pairs do not intersect.

Sample 3:
    Input:
        [()]
    Output:
        Success
    The brackets are used correctly: there are two pairs of brackets - first pair of [ and
    ], and second pair of ( and ) - and the second pair is nested inside the first pair.

Sample 4:
    Input:
        (())
    Output:
        Success
    Pairs with the same types of brackets can also be nested.

Sample 5:
    Input:
        {[]}()
    Output:
        Success
    Here there are 3 pairs of brackets, one of them is nested into another one, and the
    third one is separate from the first two.

Sample 6:
    Input:
        {
    Output:
        1
    The code { doesn't use brackets correctly, because brackets cannot be divided into
    pairs (there is just one bracket). There are no closing brackets, and the first
    unmatched opening bracket is {, and its position is 1, so we output 1.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CheckBrackets {

    private static class Bracket {
        Bracket(char type, int position) {
            this.type = type;
            this.position = position;
        }

        boolean Match(char c) {
            if (this.type == '[' && c == ']')
                return true;
            if (this.type == '{' && c == '}')
                return true;
            if (this.type == '(' && c == ')')
                return true;
            return false;
        }

        char type;
        int position;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        System.out.println(checkBrackets(text));

    }

    public static String checkBrackets(String text) {

        Stack<Bracket> opening_brackets_stack = new Stack<>();
        for (int positon = 0; positon < text.length(); ++positon) {
            char next = text.charAt(positon);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                Bracket nextBracket = new Bracket(next, positon+1);
                opening_brackets_stack.push(nextBracket);
            } else if (next == ')' || next == ']' || next == '}') {
                if (opening_brackets_stack.isEmpty()) {
                    return String.valueOf(positon+1);
                }
                // process closing bracket, write your code here
                else if (opening_brackets_stack.peek().Match(next)) {
                    opening_brackets_stack.pop();
                } else return String.valueOf(positon+1);
            }
        }

        if (!opening_brackets_stack.isEmpty()) {
            return String.valueOf(opening_brackets_stack.peek().position);
        } else {
            return "Success";
        }
    }
}
