package HackerRank;

public class Palindrome {
    public static void main(String[] args) {
        String s = "bcbc";

        int solution = palindromeIndex(s);

        System.out.println(solution);
    }


    public static int palindromeIndex(String s) {
        // Write your code here
        int start = 0;
        int end = s.length() - 1;
        int indexToRemove = -1;

        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
                continue;
            }
            if (indexToRemove != -1)
                return -1;
            if (s.charAt(start + 1) == s.charAt(end)) {
                indexToRemove = start;
                start += 2;
                end--;
            } else if (s.charAt(start) == s.charAt(end - 1)) {
                indexToRemove = end;
                start++;
                end -= 2;
            } else return -1;
        }

        return indexToRemove;
    }
}
