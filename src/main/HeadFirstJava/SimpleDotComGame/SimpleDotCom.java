package main.HeadFirstJava.SimpleDotComGame;

import java.util.ArrayList;

public class SimpleDotCom {

    // Declare an int array (locationCells) to hold the location cells.
    int[] locationCells;
    // Declare an in (nuOfHits) to hold the number of hits, set it to 0.
    int numOfHits = 0;
    // Create ArrayList to hold previous guesses
    ArrayList<Integer> previousGuess = new ArrayList<>();

    // Declare a checkYourself() method that takes a String for the user's guess("1", "3", etc.), checks it, and returns a result representing "hit", "miss", or "kill".
    // Declare a setLocationCells() setter method that takes an int array (which ahs the three cell locations as ints (2, 3, 4, etc.).
    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    // Method: String checkYourself(String userGuess)
        // Get the user guess as a String parameter
    public String checkYourself(String stringGuess) {
        // Convert the user guess to an int
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        // check if current guess was previously guessed
        for (int i = 0; i < previousGuess.size(); i++) {
            if (guess == previousGuess.get(i)) {
                System.out.println("You already guessed this number");
                return "Guess again";
            }
        }
        // add guess to previousGuess ArrayList
        previousGuess.add(guess);
        // repeat with each of the location cells in the int array
        for (int cell : locationCells) {
            // Compare the user guess to the location cell:
            // if the user guess matches
            if (guess == cell) {
                result = "hit";
                // increment the number of hits
                numOfHits++;
                break;
                // else the user guess did not match, so return "miss"
                // end if
            }
        // end repeat
        }
        // find out if it was the last location cell
        // if number of hits is 3, return "kill" as the result
        if (numOfHits == locationCells.length) {
            // else it was not a kill, so return "hit"
            result = "kill";
            // end if
        }
        System.out.println(result);
        return result;
    // end method
    }

    // method: void setLocationCells(int[] cellLocations)
        // get the cell locations as an int array parameter
        // assign the cell locations parameter to the cell locations instance variable
    // end method

}
