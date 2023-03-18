package com.TicTacToe;

import java.util.Scanner;

public class GAME {
    // My new version (this works):
    // The others (TicTacToe's) checkWinner() method was wrong

    static String[][] board = {
            {"  " , "|" , "  " , "|" , "  "},
            {"--", "+", "--", "+", "--"},
            {"  ", "|", "  ", "|", "  "},
            {"--", "+", "--", "+", "--"},
            {"  ", "|", "  ", "|", "  "}
    };

    static boolean winner = false;


    public static void main(String[] args) {

        runGame();

    }

    public static void runGame(){
        gameBoard();

        // My new solution without repetition:
        while (true){
            guess(board, 1);
            gameBoard();
            if(winner){
                break;
            }

            guess(board, 2);
            if(winner){
                gameBoard();
                break;
            }
            gameBoard();
        }

            // Old solution with repeating code (still works the same)
//        while (!winner){
//            player1Guess(board);
//            gameBoard();
//            if(winner){
//                break;
//            }
//
//            player2Guess(board);
//            if(winner){
//                gameBoard();
//                break;
//            }
//            gameBoard();
//        }


    }

    public static void gameBoard(){

        for (String[] row : board) {
            for (String c : row) {
                System.out.print(c);
            }
            System.out.println(); // To print out the board on separate lines
        }
    }

    public static void guess(String[][] board, int player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please place your placement");
        int playerInput = scanner.nextInt();

        String symbol;
        if(player == 1){
            symbol = "X ";
        }else{
            symbol = "O ";
        }

        switch (playerInput) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
        }

        int thisPlayer = player;
        checkWinner(symbol, thisPlayer);
    }

    public static  void checkWinner(String symbol, int player){
        // Horizontal
        if(board[0][0] == symbol && board[0][2] == symbol && board [0][4] == symbol){
            winner = true;
            System.out.println("Player " + player + " has won the game");
        }
        if(board[2][0] == symbol && board[2][2] == symbol && board [2][4] == symbol ) {
            winner = true;
            System.out.println("Player " + player + " has won the game");
        }
        if(board[4][0] == symbol && board[4][2] == symbol && board [4][4] == symbol) {
            winner = true;
            System.out.println("Player " + player + " has won the game");
        }
        // Vertical
        if(board[0][0] == symbol && board[2][0] == symbol && board [4][0] == symbol ) {
            winner = true;
            System.out.println("Player " + player + " has won the game");
        }
        if(board[0][2] == symbol && board[2][2] == symbol && board [4][2] == symbol ) {
            winner = true;
            System.out.println("Player " + player + " has won the game");
        }
        if(board[0][4] == symbol && board[2][4] == symbol && board [4][4] == symbol ) {
            winner = true;
            System.out.println("Player " + player + " has won the game");
        }
        // Across
        if(board[0][0] == symbol && board[2][2] == symbol && board [4][4] == symbol ) {
            winner = true;
            System.out.println("Player " + player + " has won the game");
        }
        if(board[4][0] == symbol && board[2][2] == symbol && board [0][4] == symbol ) {
            winner = true;
            System.out.println("Player " + player + " has won the game");
        }
    }


//    public static void player1Guess(String[][] board) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please place your placement");
//        int player1 = scanner.nextInt();
//
//
//        switch (player1) {
//            case 1:
//                board[0][0] = "X ";
//                break;
//            case 2:
//                board[0][2] = "X ";
//                break;
//            case 3:
//                board[0][4] = "X ";
//                break;
//            case 4:
//                board[2][0] = "X ";
//                break;
//            case 5:
//                board[2][2] = "X ";
//                break;
//            case 6:
//                board[2][4] = "X ";
//                break;
//            case 7:
//                board[4][0] = "X ";
//                break;
//            case 8:
//                board[4][2] = "X ";
//                break;
//            case 9:
//                board[4][4] = "X ";
//                break;
//        }
//
//        checkWinner();
//    }
//
//    public static void player2Guess(String[][] board) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Player 2 enter your placement");
//        int player2 = scanner.nextInt();
//
//        switch (player2) {
//            case 1:
//                board[0][0] = "O ";
//                break;
//            case 2:
//                board[0][2] = "O ";
//                break;
//            case 3:
//                board[0][4] = "O ";
//                break;
//            case 4:
//                board[2][0] = "O ";
//                break;
//            case 5:
//                board[2][2] = "O ";
//                break;
//            case 6:
//                board[2][4] = "O ";
//                break;
//            case 7:
//                board[4][0] = "O ";
//                break;
//            case 8:
//                board[4][2] = "O ";
//                break;
//            case 9:
//                board[4][4] = "O ";
//                break;
//        }
//
//        checkWinner();
//    }

//        public static  void checkWinner(){
//        if(board[0][0] == "X" && board[0][2] == "X" && board [0][4] == "X"){
//            winner = true;
//            System.out.println("Player 1 has won the game");
//        }
//        if(board[2][0] == "X " && board[2][2] == "X " && board [2][4] == "X " ) {
//            winner = true;
//            System.out.println("Player 1 has won the game");
//        }
//        if(board[4][0] == "X " && board[4][2] == "X " && board [4][4] == "X ") {
//            winner = true;
//            System.out.println("Player 1 has won the game");
//        }
//        if(board[0][0] == "X " && board[2][0] == "X " && board [4][0] == "X " ) { //Vertical
//            winner = true;
//            System.out.println("Player 1 has won the game");
//        }
//        if(board[0][2] == "X " && board[2][2] == "X " && board [4][2] == "X " ) {
//            winner = true;
//            System.out.println("Player 1 has won the game");
//        }
//        if(board[0][4] == "X " && board[2][4] == "X " && board [4][4] == "X " ) {
//            winner = true;
//            System.out.println("Player 1 has won the game");
//        }
//        if(board[0][0] == "X " && board[2][2] == "X " && board [4][4] == "X " ) { //Across
//            winner = true;
//            System.out.println("Player 1 has won the game");
//        }
//        if(board[4][0] == "X " && board[2][2] == "X " && board [0][4] == "X " ) {
//            winner = true;
//            System.out.println("Player 1 has won the game");
//        }
//
//        if(board[0][0] == "O " && board[0][2] == "O " && board [0][4] == "O " ) { //Horizontal
//            winner = true;
//            System.out.println("Player 1 has won the game");
//        }
//        if(board[2][0] == "O " && board[2][2] == "O " && board [2][4] == "O " ) {
//            winner = true;
//            System.out.println("Player 2 has won the game");
//        }
//        if(board[4][0] == "O " && board[4][2] == "O " && board [4][4] == "O " ) {
//            winner = true;
//            System.out.println("Player 2 has won the game");
//        }
//        if(board[0][0] == "O " && board[2][0] == "O " && board [4][0] == "O " ) { //Vertical
//            winner = true;
//            System.out.println("Player 2 has won the game");
//        }
//        if(board[0][2] == "O " && board[2][2] == "O " && board [4][2] == "O " ) {
//            winner = true;
//            System.out.println("Player 2 has won the game");
//        }
//        if(board[0][4] == "O " && board[2][4] == "O " && board [4][4] == "O " ) {
//            winner = true;
//            System.out.println("Player 2 has won the game");
//        }
//        if(board[0][0] == "O " && board[2][2] == "O " && board [4][4] == "O " ) { //Across
//            winner = true;
//            System.out.println("Player 2 has won the game");
//        }
//        if(board[4][0] == "O " && board[2][2] == "O " && board [0][4] == "O " ) {
//            winner = true;
//            System.out.println("Player 2 has won the game");
//        }
//    }

}
