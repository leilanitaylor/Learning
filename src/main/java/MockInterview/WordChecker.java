package MockInterview;

import java.util.Arrays;
import java.util.List;

/**
 * Below is a Java class that checks certain
 * conditions for words. You want to be able
 * to add new checks generically. Refactor
 * the class to support an arbitrary number of checks.
 */
public class WordChecker
{
    private List<Check> checks;

    public WordChecker(List<Check> checks)
    {
        this.checks = checks;
    }

    public static void main(String[] args) {
        List<Check> checks = Arrays.asList();
        WordChecker test = new WordChecker(checks);
    }

    public void processWords(List<String> words)
    {
        for (String word : words)
        {
            if (this.check(word))
                System.out.println(word);
        }
    }

    protected boolean check(String word) {
        for (Check check : checks) {
            if (check.check(word))
                return true;
        }
        return false;
            /*
    {
        if (this.checkStartsWithT)
        {
            if (word.toLowerCase().startsWith("t"))
                return true;
        }
        if (this.checkPalindrome)
        {
            boolean pass = true;
            for (int i = 0; i < word.length() / 2; i++)
            {
                if (word.charAt(i) != word.charAt(word.length() - i - 1))
                    pass = false;
            }
            if (pass)
                return true;
        }
        if (this.checkLongerThan10)
        {
            if (word.length() > 10)
                return true;
        }

        if (this.checkLongerThan20) {
            if (word.length() > 20)
                return true;
        }
        return false;

             */
    }

    private abstract class Check {
        public abstract boolean check(String word);
    }

private class checkStartsWithT extends Check {


    @Override
    public boolean check(String word) {
        if (word.toLowerCase().startsWith("t"))
           return true;
        return false;
    }
}

}