package HeadFirstJava.PoolPuzzleThree;

public class Triangle {
    double area;
    int height;
    int length;
    public static void main(String[] args) {
        // code
        int x = 0;
        // code
        Triangle[] ta = new Triangle[4];
        while (x < 4) {
            // code
            ta[x] = new Triangle();
            // ____.height = (x + 1) * 2;
            ta[x].height = (x + 1) * 2;
            // ____.length = x + 4;
            ta[x].length = x + 4;
            // code
            ta[x].setArea();
            System.out.print("triangle " + x + ", area");
            // System.out.println(" = " + ____.area);
            System.out.println(" = " + ta[x].area);
            // code
            x = x + 1;
        }
        // code
        int y = x;
        x = 27;
        Triangle t5 = ta[2];
        ta[2].area = 343;
        System.out.print("y = " + y);
        System.out.println(", t5 area = " + t5.area);
    }

    void setArea () {
        // ____ = (height * length) / 2;
        area = (height * length) / 2;
    }
}
