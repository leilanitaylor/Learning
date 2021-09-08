package juniorJavaDevClass.Labs.Lab3;

public class NoNumberException extends Exception {

    String password;

    NoNumberException (String password) {
        this.password = password;
    }

    public String toString() {
        return password + " does not contain a number.";
    }
}
