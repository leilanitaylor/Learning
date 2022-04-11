package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TruckTour {
    public static void main(String[] args) {
        List<List<Integer>> petrolpumps = new ArrayList<>();

        petrolpumps.add(Arrays.asList(1, 5));
        petrolpumps.add(Arrays.asList(10, 3));
        petrolpumps.add(Arrays.asList(3, 4));

        int result = truckTour(petrolpumps);

        System.out.println(result);
    }

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        int startingPump = -1;

        for (int i = 0; i < petrolpumps.size(); i++) {
            startingPump = i;
            int currentPump = i;
            int totalFuel = 0;
            int numPumpsVisited = 0;

            while (numPumpsVisited < petrolpumps.size()) {
                totalFuel = totalFuel + petrolpumps.get(currentPump).get(0) - petrolpumps.get(currentPump).get(1);
                if (totalFuel < 0)
                    break;
                numPumpsVisited++;
                currentPump++;
                if (currentPump >= petrolpumps.size())
                    currentPump = 0;
            }

            if (numPumpsVisited == petrolpumps.size())
                return startingPump;
        }

        return startingPump;
    }

}
