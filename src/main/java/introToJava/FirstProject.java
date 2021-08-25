package introToJava;

public class FirstProject {
    public static void main(String[] args) {
        FirstProject.hello(7);
    }

    static void hello(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println("Hello World");
        }
    }
}


