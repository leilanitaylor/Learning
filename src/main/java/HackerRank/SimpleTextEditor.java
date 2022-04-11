package HackerRank;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    public static class Solution {
        static Stack<Operation> commands = new Stack<>();
        static Stack<String> deletedCharacters = new Stack<>();

        public static void main(String[] args) throws FileNotFoundException {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            String s = "";

            Path path = Paths.get("src/main/resources").resolve("SimpleTextEditor.txt");
            File textEditorFile = path.toFile();

            Scanner sc = new Scanner(textEditorFile);

            int q = sc.nextInt();

            int operationIndex = 0;

            while (operationIndex < q) {
                int nextCommand = sc.nextInt();
                Operation nextOperation;
                if (nextCommand == 1) {
                    nextOperation = new Operation(nextCommand, sc.next());
                    s = appendString(s, nextOperation);
                    commands.push(nextOperation);
                } else if (nextCommand == 2 || nextCommand == 3) {
                    nextOperation = new Operation(nextCommand, sc.nextInt());
                    if (nextOperation.oper == 2) {
                        s = deleteCharacters(s, nextOperation);
                        commands.push(nextOperation);
                    } else {
                        printCharacter(s, nextOperation);
                    }
                } else {
                    s = undoPrevious(s);
                }
                operationIndex++;
            }
        }

        public static String appendString(String s, Operation currentOperation) {
            s = s + currentOperation.item;
            return s;
        }

        public static String deleteCharacters(String s, Operation currentOperation) {
            String charactersToDelete = s.substring(s.length() - currentOperation.index);
            deletedCharacters.push(charactersToDelete);
            s = s.substring(0, s.length() - currentOperation.index);
            return s;
        }

        public static void printCharacter(String s, Operation currentOperation) {
            Character charToPrint = s.charAt(currentOperation.index - 1);
            System.out.println(charToPrint);
        }

        public static String undoPrevious(String s) {
            if (commands.empty()) {
                return s;
            }
            Operation operToUndo = commands.pop();
            if (operToUndo.oper == 1) {
                String charactersToRemove = operToUndo.item;
                s = s.substring(0, s.length() - charactersToRemove.length());
                return s;
            } else {
                String charactersToAdd = deletedCharacters.pop();
                s = s + charactersToAdd;
                return s;
            }
        }

        public static class Operation {
            int oper;
            String item;
            int index;

            Operation (int oper, String item) {
                this.oper = oper;
                this.item = item;
            }

            Operation (int oper, int index) {
                this.oper = oper;
                this.index = index;
            }
        }
    }
}



/*
import java.io.*;
import java.util.*;

public class Solution {
    static Stack<Operation> commands = new Stack<>();
    static Stack<String> deletedCharacters = new Stack<>();

    public static void main(String[] args) {
        // Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
String s = "";

    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();

    int operationIndex = 0;

        while (operationIndex < q) {
        int nextCommand = sc.nextInt();
        Operation nextOperation;
        if (nextCommand == 1) {
        nextOperation = new Operation(nextCommand, sc.next());
        s = appendString(s, nextOperation);
        commands.push(nextOperation);
        } else if (nextCommand == 2 || nextCommand == 3) {
        nextOperation = new Operation(nextCommand, sc.nextInt());
        if (nextOperation.oper == 2) {
        s = deleteCharacters(s, nextOperation);
        commands.push(nextOperation);
        } else {
        printCharacter(s, nextOperation);
        }
        } else {
        s = undoPrevious(s);
        }
        operationIndex++;
        }
        }

public static String appendString(String s, Operation currentOperation) {
        s = s + currentOperation.item;
        return s;
        }

public static String deleteCharacters(String s, Operation currentOperation) {
        String charactersToDelete = s.substring(s.length() - currentOperation.index);
        deletedCharacters.push(charactersToDelete);
        s = s.substring(0, s.length() - currentOperation.index);
        return s;
        }

public static void printCharacter(String s, Operation currentOperation) {
        Character charToPrint = s.charAt(currentOperation.index - 1);
        System.out.println(charToPrint);
        }

public static String undoPrevious(String s) {
        if (commands.empty()) {
        return s;
        }
        Operation operToUndo = commands.pop();
        if (operToUndo.oper == 1) {
        String charactersToRemove = operToUndo.item;
        s = s.substring(0, s.length() - charactersToRemove.length());
        return s;
        } else {
        String charactersToAdd = deletedCharacters.pop();
        s = s + charactersToAdd;
        return s;
        }
        }

public static class Operation {
    int oper;
    String item;
    int index;

    Operation (int oper, String item) {
        this.oper = oper;
        this.item = item;
    }

    Operation (int oper, int index) {
        this.oper = oper;
        this.index = index;
    }
}
}

 */