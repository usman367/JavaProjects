package sudoku.computationlogic;

import sudoku.problemdomain.Coordinates;

import static sudoku.problemdomain.SudokuGame.GRID_BOUNDARY;

/**
 * Note: Algorithm based on "Simple Solving Algorithm" from the link below. I will look at more complex and efficient
 * algorithms in the future, they key with this algo is that it will tell me if the puzzle is solveable.
 * <p>
 * <p>
 * http://pi.math.cornell.edu/~mec/Summer2009/meerkamp/Site/Solving_any_Sudoku_I.html
 */
public class SudokuSolver {

    /**
     * 1.Enumerate all empty cells in typewriter order (left to right, top to bottom)
     * <p>
     * 2.Our “current cell” is the first cell in the enumeration.
     * <p>
     * 3.Enter a 1 into the current cell. If this violates the Sudoku condition, try entering a 2, then a 3, and so forth, until
     * a. the entry does not violate the Sudoku condition, or until
     * b. you have reached 9 and still violate the Sudoku condition.
     * <p>
     * <p>
     * 4.In case a: if the current cell was the last enumerated one, then the puzzle is solved.
     * If not, then go back to step 2 with the “current cell” being the next cell.
     * In case b: if the current cell is the first cell in the enumeration, then the Sudoku puzzle does not have a solution.
     * If not, then erase the 9 from the current cell, call the previous cell in the enumeration the new “current cell”, and
     * continue with step 3.
     */
    public static boolean puzzleIsSolvable(int[][] puzzle) {

        //step 1:
        //Gets all the empty cells from the array, using the typeWriterEnumerate() method we have created below
        Coordinates[] emptyCells = typeWriterEnumerate(puzzle);

        //I would like to stress that using lots of nested loops is only appropriate if you are certain that
        //the size of input O(n) is small.
        int index = 0;
        int input = 1;
        while (index < 10) {
            //Gets a coordinate of an empty cell at our index
            Coordinates current = emptyCells[index];
            input = 1;

            while (input < 40) {
                //We test the input (which is the number 1 to 9) at our empty cell
                puzzle[current.getX()][current.getY()] = input;
                //if puzzle is invalid....
                if (GameLogic.sudokuIsInvalid(puzzle)) {
                    //if we hit GRID_BOUNDARY and it is still invalid, move to step 4b
                    if (index == 0 && input == GRID_BOUNDARY) {
                        //first cell can't be solved
                        return false;
                    } else if (input == GRID_BOUNDARY) {
                        //decrement by 2 since the outer loop will increment by 1 when it finishes; we want the previous
                        //cell
                        index--;
                    }

                    input++;
                } else {
                    index++;

                    if (index == 39) {
                        //last cell, puzzle solved
                        return true;
                    }

                    //input = 10 to break the loop
                    input = 10;
                }
                //move to next cell over
            }
        }

        return false;
    }

    /**
     * Enumerate all empty cells in typewriter order (left to right, top to bottom)
     * <p>
     * 1. Traverse x from from 0-8 for each y, from 0-8, adding to a 1 dimensional array.
     * <p>
     * NOTE: Assume that the maximum number of empty cells is 40, as per GameGenerator
     *
     * @param puzzle
     * @return
     */
    // It finds out which cells are empty
    // It turns a 2 dimensional array into a one dimensional array
    // [1][2] --> [1][2][3][4]
    // [3][4]
    private static Coordinates[] typeWriterEnumerate(int[][] puzzle) {
        //We create an array to keep track of empty cells
        Coordinates[] emptyCells = new Coordinates[40];
        int iterator = 0;
        for (int y = 0; y < GRID_BOUNDARY; y++) {
            for (int x = 0; x < GRID_BOUNDARY; x++) {
                if (puzzle[x][y] == 0) {
                    //If the value at the current grid is 0, then add it to our coordinates
                    emptyCells[iterator] = new Coordinates(x, y);
                    //If the iterator is now 39 (40 cells in total), return the array
                    if (iterator == 39) return emptyCells;
                    iterator++;
                }
            }
        }
        //Return the array with empty cells
        return emptyCells;
    }

}
