package juniorJavaDevClass.Labs.Lab3;

public class NoSpecialCharacterException extends Exception {

    String password;

    NoSpecialCharacterException (String password) {
        this.password = password;
    }

    public String toString() {
        return password + " does not contain a special character (! @ #)";
    }
}
