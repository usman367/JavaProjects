package sudoku.persistence;

import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;

import java.io.*;

/**
 * JSON is a simple language which is commonly used for storage and data transfer in Desktop, Web, and Mobile
 * programming. By having one simple language which can be understood by a wide variety of different platforms and
 * operating systems, this makes life easier for us programmers to have our programs communicate with each other, and
 * work on more devices.
 */
public class LocalStorageImpl implements IStorage {

    private static File GAME_DATA = new File(
            // Its a path/url, retrieves the Operating systems home directory
            // It will store a file called gamedata.txt
            //We will use this file for storing and retrieving data
            System.getProperty("user.home"),
            "gamedata.txt"
    );

    // Writing to the local file system
    @Override
    public void updateGameData(SudokuGame game) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            objectOutputStream.close();

        } catch (IOException e) {
            throw new IOException("Unable to access Game Data");
        }
    }

    // Reading the data from the file system
    @Override
    public SudokuGame getGameData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(GAME_DATA);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            SudokuGame gameState = (SudokuGame) objectInputStream.readObject();
            objectInputStream.close();
            return gameState;

        } catch (ClassNotFoundException e) {
            throw new IOException("File Not Found");
        }
    }

}
