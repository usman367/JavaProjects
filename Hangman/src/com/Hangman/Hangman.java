package com.Hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        //String[] alph = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        //System.out.println(Arrays.toString(alph));

        String word = "";
        int lifes = 5;
        char guess;
        //char[] dashedWord = new char[word.length()];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1: Please enter a word");
        word = scanner.next();
        //System.out.println(word);

        char[] dashedWord = new char[word.length()];
        int i=0;

        while (i<word.length()) {
            dashedWord[i]='-';
            if(word.charAt(i) == ' ') {
                dashedWord[i]= ' ';
            }
            i++;
        }

        System.out.println(dashedWord);
        System.out.println(" Lifes remaining: " + lifes);

        Scanner scanner2 = new Scanner(System.in);

        while (lifes>0) {
            guess = scanner2.next().charAt(0); //character input by user (new variable)

            if (word.contains(guess+"")) {
                for (int y=0 ; y<word.length(); y++){ //looping through the word to find where the guess is
                    if (word.charAt(y)==guess) { // When the guess is found
                        dashedWord[y]=guess; // replace the dash with the guess
                    }
                }
            }
            else {
                lifes--;
            }

            if(word.equals(String.valueOf(dashedWord))) {
                System.out.println(dashedWord);
                System.out.println("You won!");
            }

            System.out.println( dashedWord);
            System.out.println(" You had " + lifes + " lifes remaining: ");

        }

        if (lifes==0) {
            System.out.println("You lose!");

        }
    }
}
