package juniorJavaDevClass.Labs.Lab3;

public class NoLetterException extends Exception {

    String password;

    NoLetterException (String password) {
        this.password = password;
    }

    public String toString() {
        return password + " does not contain a letter";
    }
}
