package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class YearOfChaos {
    public static void main(String[] args) {
        List<Integer> q = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);

        minimumBribes(q);
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int numBribes = 0;
        int bribes = 0;
        int prevBribe = 0;

        for (int i = 0; i < q.size(); i++) {
            if (numBribes == -1)
                break;
            if (q.get(i) > i+1) {
                bribes = q.get(i) - i - 1;
                if (bribes > 2) {
                    numBribes = -1;
                    break;
                }
            } else if (prevBribe != 0 && q.get(i) > i+1 - prevBribe) {
                bribes = q.get(i) - i - 1 + prevBribe;
            }
            numBribes += bribes;
            prevBribe = bribes;
        }

        if (numBribes == -1)
            System.out.println("Too chaotic");
      /*  else {
            List<Integer> sortQ = new ArrayList<>();
            for (int i = 0; i < q.size(); i++) {
                sortQ.add(q.get(i));
            }
            Collections.sort(sortQ);

            while (sortQ.equals(q) != true) {
                for (int i = 0; i < q.size() - 1; i++) {
                    if (q.get(i) > q.get(i+1)) {
                        int temp = q.get(i);
                        q.set(i, q.get(i+1));
                        q.set(i+1, temp);
                        numBribes++;
                        break;
                    }
                }
            }


       */
            System.out.println(numBribes);

    }

}
