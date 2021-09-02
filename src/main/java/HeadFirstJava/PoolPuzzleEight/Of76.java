package HeadFirstJava.PoolPuzzleEight;

/*
Your job is to take code snippes from the ppol and place them into the blank lines in the code and output.
You may use the same snippet more than once, and you won't need ot use all the snippets.
Your goal is to make a set of classes that will compile and run and produce the output listed.

Output:
%java ____          %java Of76
5 class Acts        5 class Acts
7 class Clowns      7 class Clowns
____Of76            7 class Of76

comments are as listed in book, line directly below is my solution

Pool:
class               Acts();             i           class               Acts        Of76[] i = new Nose[3];     public int iMethod();       i.iMethod(x)
extends             Nose();             i()         5 class             Nose        Of76[3] i;                  public int iMethod{}        i(x).iMethod[]
interface           Of76();             i(x)        7 class             Of76        Nose[] i = new Nose();      public int iMethod() {      i[x].iMethod()
implements          Clowns();           i[x]        7 public class      Clowns      Nose[] i = new Nose[3];     public int iMethod() {}     i[x].iMethod[]
                    Picasso();                                          Picasso

 */


// public ____ ____ extends Clowns {
public class Of76 extends Clowns {

    public static void main(String[] args) {
        // ___________
        Nose[] i = new Nose[3];
        // i[0] = new ____
        i[0] = new Acts();
        // i[1] = new ____
        i[1] = new Clowns();
        // i[2] = new ____
        i[2] = new Of76();
        for (int x = 0; x < 3; x++) {
            // System.out.println(____ + " " + ____.getClass());
            System.out.println(i[x].iMethod() + " " + i[x].getClass());
        }
    }

}
