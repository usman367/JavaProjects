package com.TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    int player1;
    int player2;
    //boolean winner;


    public static void main(String[] args) {
        //int player1 = 0;
        //int player2;
        boolean winner = false;

        String[][] board = {
                {"  " , "|" , "  " , "|" , "  "},
                {"--", "+", "--", "+", "--"},
                {"  ", "|", "  ", "|", "  "},
                {"--", "+", "--", "+", "--"},
                {"  ", "|", "  ", "|", "  "}
        };

        while(!winner){
            gameBoard(board);
            player1Guess(board);
            gameBoard(board);
            player2Guess(board);
            gameBoard(board);
            checkWinner(winner, board);
        }

        if(winner == true){

        }
    }

    public static void gameBoard(String[][] board) {
        for (String[] row : board) {
            for (String c : row) {
                System.out.print(c);
            }
            System.out.println(); // To print out the board on separate lines
        }
        //System.out.println(Arrays.deepToString(board));
        //System.out.println(Arrays.deepToString(board).replace("], ", "]\n"));
    }

    public static void player1Guess(String[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please place your placement");
        int player1 = scanner.nextInt();

        switch (player1) {
            case 1:
                board[0][0] = "X ";
                break;
            case 2:
                board[0][2] = "X ";
                break;
            case 3:
                board[0][4] = "X ";
                break;
            case 4:
                board[2][0] = "X ";
                break;
            case 5:
                board[2][2] = "X ";
                break;
            case 6:
                board[2][4] = "X ";
                break;
            case 7:
                board[4][0] = "X ";
                break;
            case 8:
                board[4][2] = "X ";
                break;
            case 9:
                board[4][4] = "X ";
                break;
        }


        //if (player1 == 1) {
        //  board[0][0] = "x ";
        //}
        //if (player1 == 2) {
        //  board[0][2] = "x ";
        //}
        //if (player1 == 3) {
        //  board[1][4] = "x ";
        //}
    }
    public static void player2Guess(String[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 2 enter your placement");
        int player2 = scanner.nextInt();

        switch (player2) {
            case 1:
                board[0][0] = "O ";
                break;
            case 2:
                board[0][2] = "O ";
                break;
            case 3:
                board[0][4] = "O ";
                break;
            case 4:
                board[2][0] = "O ";
                break;
            case 5:
                board[2][2] = "O ";
                break;
            case 6:
                board[2][4] = "O ";
                break;
            case 7:
                board[4][0] = "O ";
                break;
            case 8:
                board[4][2] = "O ";
                break;
            case 9:
                board[4][4] = "O ";
                break;
        }
    }



    public static void checkWinner(boolean winner,String[][] board) {
        //winner = false;
        if(board[0][0] == board[0][2] == board [0][4] .equals("X ")) { //Horizontal
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[2][0] == board[2][2] == board [2][4] .equals("X ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[4][0] == board[4][2] == board [4][4] .equals("X ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[0][0] == board[0][2] == board [0][4] .equals("X ")) { //Vertical
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[2][0] == board[2][2] == board [2][4] .equals("X ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[4][0] == board[4][2] == board [4][4] .equals("X ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[0][0] == board[2][2] == board [4][4] .equals("X ")) { //Across
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[4][0] == board[2][2] == board [0][4] .equals("X ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[0][0] == board[0][2] == board [0][4] .equals("O ")) { //Horizontal
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[2][0] == board[2][2] == board [2][4] .equals("O ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[4][0] == board[4][2] == board [4][4] .equals("O ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[0][0] == board[0][2] == board [0][4] .equals("O ")) { //Vertical
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[2][0] == board[2][2] == board [2][4] .equals("O ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[4][0] == board[4][2] == board [4][4] .equals("O ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[0][0] == board[2][2] == board [4][4] .equals("O ")) { //Across
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
        if(board[4][0] == board[2][2] == board [0][4] .equals("O ")) {
            winner = true;
            //return winner;
            System.out.println("Player 1 has won the game");
        }
    }


}
