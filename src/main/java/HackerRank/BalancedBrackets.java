package HackerRank;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String s = "}][}}(}][))]";

        String answer = isBalanced(s);

        System.out.println(answer);
    }

    public static String isBalanced(String s) {
        // Write your code here
        Stack currentStack = new Stack();

        for (int i = 0; i < s.length(); i ++) {
            switch (s.charAt(i)) {
                case '(':
                    currentStack.push(s.charAt(i));
                    break;
                case '{':
                    currentStack.push(s.charAt(i));
                    break;
                case '[':
                    currentStack.push(s.charAt(i));
                    break;
                case ')':
                    if (currentStack.empty())
                        return "NO";
                    if ((char)currentStack.pop() == '(') {
                        break;
                    } else return "NO";
                case '}':
                    if ((char)currentStack.pop() == '{') {
                        break;
                    } else return "NO";
                case ']':
                    if ((char)currentStack.pop() == '[') {
                        break;
                    } else return "NO";
                default:
                    return "NO";
            }
        }

        if (currentStack.empty()) {
            return "YES";
        }
        return "NO";
    }
}
