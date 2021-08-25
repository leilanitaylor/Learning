package HeadFirstJava.DotComGame;

import java.util.*;

public class DotComBust {
    // DECLARE and instantiate the GameHelper instance variable, named helper
    private GameHelper helper = new GameHelper();
    // DECLARE and instantiate an ArrayList to hold the lit of DotComs (initially three). Call it dotComsList
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    // DECLARE an int variable to hold the number of user guesses (so that we can give the user a score at the end of the game). Name it numOfGuesses and set it to 0.
    private int numOfGuesses = 0;

    // DECLARE a setUpGame() method to create and initialize the DotCom objects with names and locations. Display brief instructions to the user
    // DECLARE a startPlaying() method that asks the player for guesses and calls the checkUserGuess() method until all the DotCom objects are removed from play
    // DECLARE a checkUserGuess() method that loops through all remaining DotCom objects and calls each DotCom object's checkYourself() method
    // DECLARE a finishGame() method that prints a message about the user's performance, based on how many guesses it too to sink all the DotCom objects

    // METHOD: void setUpGame()
    private void setUpGame() {
        // make three DotCom objects and name them
        // CREATE three DotCom objects
        DotCom one = new DotCom();
        DotCom two = new DotCom();
        DotCom three = new DotCom();
        // SET a name for each DotCom
        one.setName("Pets.com");
        two.setName("eToys.com");
        three.setName("Go2.com");
        // ADD the DotComs to the dotComsList (the ArrayList)
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        // Print instructions
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewwest number of guesses");

        // REPEAT with each of the DotCom objects int the dotComsList array
        for (DotCom dotComToSet : dotComsList) {
            // CALL the placeDotCom() method on the helper object, to get a randomly-selected location for htis DotCom (three cells, verticaly or horizontally aligned, on a 7 x 7 grid)
            ArrayList<String> newLocation = helper.placeDotCom(3);
            // SET the location for each DotCom based on teh result of the placeDotCom() call
            dotComToSet.setLocationCells(newLocation);
        } // end REPEAT
    } // end METHOD

    // METHOD: void startPlaying()
    private  void startPlaying() {
        // REPEAT while any DotComs exist
        while (!dotComsList.isEmpty()) {
            // GET user input by calling the helper getUserInput() method
            String userGuess = helper.getUserInput("Enter a guess");
            // EVALUATE the user's guess by checkUserGuess() method
            checkUserGuess(userGuess);
        } // end REPEAT
        finishGame();
    } // end METHOD

    // METHOD: void checkUserGuess(String userGuess)
    private void checkUserGuess(String userGuess) {
        // INCREMENT the number of user guesses in the numOfGuesses variable
        numOfGuesses++;
        // SET the local result variable (a String) to "miss", assuming the user's guess will be a miss
        String result = "miss";
        // find out if there's a hit (and kill) on any DotCom
        // REPEAT with each of the DotObjects in teh dotComsList array
        for (DotCom dotComToTest : dotComsList) {
            // EVALUATE the user's guess by calling the DotCom object's checkYourself() method
            result = dotComToTest.checkYourself(userGuess);
            // SET the result variable to "hit" or "kill" if appropriate
            if (result.equals("hit")) {
                break;
            }
            // IF the result is "kill", REMOVE the DotCom from the dotComsList
            if (result.equals("kill")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        } // end REPEAT
        // DISPLAY the result value to the user
        System.out.println(result);
    } // end METHOD

    // METHOD: void finishGame()
    private void finishGame() {
        // DISPLAY a generic "game over" message, then:
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        // IF number of user guesses is small,
        if (numOfGuesses <= 18) {
            // DISPLAY a congratulations message
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println(" You got out before your options sank.");
        } else { // ELSE
            // DISPLAY an insulting one
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        } // end IF
    } // end METHOD

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
