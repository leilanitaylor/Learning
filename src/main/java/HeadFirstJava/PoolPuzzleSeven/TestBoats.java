package HeadFirstJava.PoolPuzzleSeven;

public class TestBoats {
    // ____ ____ ____ main(String[] args) {
    public static void main(String[] args) {
        // ____ b1 = new Boat();
        Boat b1 = new Boat();
        // Sailboat b2 = new ____();
        Sailboat b2 = new Sailboat();
        // Rowboat ____ = new Roaboat();
        Rowboat b3 = new Rowboat();
        b2.setLength(32);
        // b1.____();
        b1.move();
        // b3.____();
        b3.move();
        // ____.move();
        b2.move();
    }
}
