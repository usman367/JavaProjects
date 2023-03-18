package sudoku.computationlogic;

import sudoku.problemdomain.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static sudoku.problemdomain.SudokuGame.GRID_BOUNDARY;

public class GameGenerator {

    public static int[][] getNewGameGrid() {
        return unsolveGame(getSolvedGame());
    }

    /**
     * 1. Generate a new 9x9 2D Array.
     * 2. For each value in the range 1..9, allocate that value 9 times based on the following constraints:
     * - A Random coordinate on the grid is selected. If it is empty, a Random value is allocated.
     * - The resulting allocation must not produce invalid rows, columns, or squares.
     * - If the allocation does produce an invalid game
     *
     * @return
     */
    // Gets the solved Sudoku game
    private static int[][] getSolvedGame() {
        Random random = new Random(System.currentTimeMillis());
        //We create a new grid
        int[][] newGrid = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        //Value represents potential values for each square. Each value must be allocated 9 times.
        for (int value = 1; value <= GRID_BOUNDARY; value++) {
            //allocations refers to the number of times in which a square has been given a value.
            int allocations = 0;

            //If too many allocation attempts are made which end in an invalid game, we grab the most recent
            //allocations stored in the List below, and reset them all to 0 (empty).
            int interrupt = 0;

            //Keep track of what has been allocated in the current frame of the loop
            List<Coordinates> allocTracker = new ArrayList<>();

            //As a failsafe, if we keep rolling back allocations on the most recent frame, and the game still
            //keeps breaking, after 500 times we reset the board entirely and start again.
            int attempts = 0;

            //While the number of times we've allocated a number is less than 9
            while (allocations < GRID_BOUNDARY) {
                //Keep attempting to allocate that number

                if (interrupt > 200) {
                    //If we've tried to allocate the number more than 200 times
                    allocTracker.forEach(coord -> {
                        //Then we go through the past numbers we've allocated and set them to 0
                        newGrid[coord.getX()][coord.getY()] = 0;
                    });

                    //Reset the numbers
                    interrupt = 0;
                    allocations = 0;
                    allocTracker.clear();
                    attempts++;

                    //If we've tried to allocate this number more than 500 times, then we reset the whole thing
                    if (attempts > 500) {
                        //We reset the variables and try again, by calling our clearArray() method from below
                        clearArray(newGrid);
                        attempts = 0;
                        value = 1;
                    }
                }

                //Each time we have to allocate a number to a square, we generate random x and y values
                int xCoordinate = random.nextInt(GRID_BOUNDARY);
                int yCoordinate = random.nextInt(GRID_BOUNDARY);

                //If the value at that square is 0, then we allocate our value to it
                if (newGrid[xCoordinate][yCoordinate] == 0) {
                    newGrid[xCoordinate][yCoordinate] = value;

                    //if value results in an invalid game, then re-assign that element to 0 and try again
                    if (GameLogic.sudokuIsInvalid(newGrid)) {
                        newGrid[xCoordinate][yCoordinate] = 0;
                        interrupt++;
                    }
                    //otherwise, indicate that a value has been allocated, and add it to the allocation tracker.
                    else {
                        allocTracker.add(new Coordinates(xCoordinate, yCoordinate));
                        allocations++;
                    }
                }
            }
        }
        return newGrid;
    }

    /**
     * The purpose of this function is to take a game which has already been solved (and thus proven to be solvable),
     * and randomly assign a certain number of tiles to be equal to 0. It appears that there is no straight
     * forward way to check if a puzzle is still solvable after removing the tiles, beyond using another algorithm
     * to attempt to re-solve the problem.
     *
     * 1. Copy values of solvedGame to a new Array (make into a helper)
     * 2. Remove 40 Values randomly from the new Array.
     * 3. Test the new Array for solvablility.
     * 4a. Solveable -> return new Array
     * 4b. return to step 1
     * @param solvedGame
     * @return
     */
    private static int[][] unsolveGame(int[][] solvedGame) {
        Random random = new Random(System.currentTimeMillis());

        boolean solvable = false;

        //note: not actually solvable until the algorithm below finishes!
        int[][] solvableArray = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        while (solvable == false){

            //Take values from solvedGame and write to new unsolved; i.e. reset to initial state
            SudokuUtilities.copySudokuArrayValues(solvedGame, solvableArray);

            //remove 40 random numbers
            int index = 0;
            while (index < 40) {
                int xCoordinate = random.nextInt(GRID_BOUNDARY);
                int yCoordinate = random.nextInt(GRID_BOUNDARY);

                //If its not equal to 0, then we set it to 0
                if (solvableArray[xCoordinate][yCoordinate] != 0) {
                    solvableArray[xCoordinate][yCoordinate] = 0;
                    index++;
                }
            }

            //Attempt to solve the puzzle again
            int[][] toBeSolved = new int[GRID_BOUNDARY][GRID_BOUNDARY];
            SudokuUtilities.copySudokuArrayValues(solvableArray, toBeSolved);

            //check if result is solvable
            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);

            //TODO Delete after tests
            System.out.println(solvable);
        }

        return solvableArray;
    }

    //Sets every element in the array to 0
    private static void clearArray(int[][] newGrid) {
        for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
            for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
                newGrid[xIndex][yIndex] = 0;
            }
        }
    }

}
