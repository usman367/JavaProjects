package sudoku.buildlogic;

import sudoku.computationlogic.GameLogic;
import sudoku.persistence.LocalStorageImpl;
import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;
import sudoku.userinterface.IUserInterfaceContract;
import sudoku.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    /**
     * This class takes in the uiImpl object which is tightly-coupled to the JavaFX framework,
     * and binds that object to the various other objects necessary for the application to function.
     */
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            // Get the game data from the storage
            // will throw if no game data is found in local storage
            initialState = storage.getGameData();

        } catch (IOException e) {

            //We ask our GameLogic class to make a new game
            initialState = GameLogic.getNewGame();

            //this method below will also throw an IOException
            //if we cannot update the game data. At this point
            //the application is considered unrecoverable
            storage.updateGameData(initialState);
        }

        //We create our control logic class
        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        // Bind our control logic class to our interface
        userInterface.setListener(uiLogic);
        //We call this method to update the board with its initial state, which will basically start the game
        userInterface.updateBoard(initialState);
    }
}
