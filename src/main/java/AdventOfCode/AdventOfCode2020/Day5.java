package AdventOfCode.AdventOfCode2020;
/*
Day 5:
    Part 1: Airline uses binary space partitioning to seat people.
        The first 7 characters will be either F or B; these specify exactly one of the
        128 rows on the plane (numbered 0 through 127). Each letter tells you which
        half of a region the given seat is in. Start with the whole list of rows; the
        first letter indicates whether the seat is in the front (0 through 63) or the
        back (64 through 127). The next letter indicates which half of that region the
        seat is in, and so on until you're left with exactly one row.
        The last three characters will be either L or R; these specify exactly one of
        the 8 columns of seats on the plane (numbered 0 through 7). The same process
        as above proceeds again, this time with only three steps. L means to keep the
        lower half, while R means to keep the upper half.
        Every seat also has a unique seat ID: multiply the row by 8, then add the
        column.
        What is the highest seat ID on a boarding pass?
    Part 2: It's a completely full flight, so your seat should be the only missing
        boarding pass in your list. However, there's a catch: some of the seats at
        the very front and back of the plane don't exist on this aircraft, so they'll
        be missing from your list as well.
        Your seat wasn't at the very front or back, though; the seats with IDs +1
        and -1 from yours will be in your list.
        What is the ID of your seat?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day5 {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> boardingIds = readFile();

        int maxSeatId = getMaxSeatId(boardingIds);
        System.out.println("Max Seat ID: " + maxSeatId);


        HashSet<Integer> seatIds = getSeatIds(boardingIds);
        int mySeatId = findMissingSeat(seatIds);
        System.out.println("My seat is: " + mySeatId);
    }

    private static int findMissingSeat(HashSet<Integer> seatIds) {
        int seatId = -1;
        for (int i = 0; i < 1024; i++) {
            if (seatIds.contains(i-1) && seatIds.contains(i+1) && !seatIds.contains(i))
                seatId = i;
        }
        return seatId;
    }

    protected static HashSet<Integer> getSeatIds(List<String> boardingIds) {
        HashSet<Integer> seatIds = new HashSet<>();

        for (int i = 0; i < boardingIds.size(); i++) {
            int row = getRow(boardingIds.get(i), 0, 0, 127);
            int column = getColumn(boardingIds.get(i), 7, 0, 7);
            int seatId = (row * 8) + column;
            seatIds.add(seatId);
        }

        return seatIds;
    }

    protected static int getMaxSeatId(List<String> boardingIds) {
        int maxSeatId = 0;

        for (int i = 0; i < boardingIds.size(); i++) {
            int row = getRow(boardingIds.get(i), 0, 0, 127);
            int column = getColumn(boardingIds.get(i), 7, 0, 7);
            int seatId = (row * 8) + column;
            maxSeatId = Math.max(maxSeatId, seatId);
        }

        return maxSeatId;
    }

    protected static int getColumn(String boardingId, int index, int min, int max) {
        if (index == 9){
            if (boardingId.charAt(index) == 'R')
                return max;
            return min;
        }

        int mid = ((max - min) / 2) + min;

        if (boardingId.charAt(index) == 'R')
            return getColumn(boardingId, index+1, mid+1, max);
        if (boardingId.charAt(index) == 'L')
            return getColumn(boardingId, index+1, min, mid);
        return -1;
    }

    protected static int getRow(String boardingId, int index, int min, int max) {
        if (index == 6) {
            if (boardingId.charAt(index) == 'B')
                return max;
            return min;
        }

        int mid = ((max - min) / 2) + min;

        if (boardingId.charAt(index) == 'B')
            return getRow(boardingId, index+1, mid+1, max);
        if (boardingId.charAt(index) == 'F')
            return getRow(boardingId, index+1, min, mid);
        return -1;
    }

    private static List<String> readFile() throws FileNotFoundException {
        Path path = Paths.get("src/main/resources").resolve("Day5InputFile.txt");
        File fileOfBoardingPasses = path.toFile();
        List<String> boardingIds = new ArrayList<>();

        Scanner sc = new Scanner(fileOfBoardingPasses);
        while (sc.hasNextLine()) {
            String boardingPass = sc.nextLine();
            boardingIds.add(boardingPass);
        }

        return boardingIds;
    }
}
