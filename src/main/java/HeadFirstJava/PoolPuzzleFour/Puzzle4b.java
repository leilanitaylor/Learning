package HeadFirstJava.PoolPuzzleFour;

public class Puzzle4b {
    int ivar;
    // ____  ____ doStuff(int ____){
    public int doStuff (int factor) {
        if (ivar > 100) {
            // return ____
            return ivar * factor;
        } else {
            // return ____
            return ivar * (5 - factor);
        }
    }
}
