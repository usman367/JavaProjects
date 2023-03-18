package sudoku.userinterface.logic;

import sudoku.computationlogic.GameLogic;
import sudoku.constants.GameState;
import sudoku.constants.Messages;
import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;
import sudoku.userinterface.IUserInterfaceContract;

import java.io.IOException;

/**
 * Since this is a single screen application, just one container (class) for the logic of the user interface is
 * necessary. Break these things up when building applications with more screens/features. Don't build God Classes!
 */
public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStorage storage;
    //Remember, this could be the real UserInterfaceImpl, or it could be a test class
    //which implements the same interface!
    private IUserInterfaceContract.View view;

    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }

    /**
     * Use Case:
     * 1. Retrieve current "state" of the data from IStorage
     * 2. Update it according to the input
     * 3. Write the result to IStorage
     * @param x X coordinate of the selected input
     * @param y Y ...
     * @param input Which key was entered, One of:
     *  - Numbers 0-9
     *
     */
    //When the user inputs or deletes a number, we'll write it to game storage
    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = storage.getGameData();
            // Get the grid and add the new input to it
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            //If that works successfully, we create a new Sudoku game object
            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );

            //We update the game data
            storage.updateGameData(gameData);

            //either way, update the view
            view.updateSquare(x, y, input);

            //if game is complete, show dialog
            if (gameData.getGameState() == GameState.COMPLETE) view.showDialog(Messages.GAME_COMPLETE);

        } catch (IOException e) {
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    //If the user clicks the ok dialog, we start a new game
    @Override
    public void onDialogClick() {
        try {
            //We update the storage before we update the user interface
            storage.updateGameData(
                    GameLogic.getNewGame()
            );

            view.updateBoard(storage.getGameData());

        } catch (IOException e) {
            view.showError(Messages.ERROR);
        }
    }
}
