package com.GuessTheNumber;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int rand = (int) Math.round(Math.random() * 100); //Don't have to put Math.round
        System.out.println(rand);
        int number = 0;
        int guesses = 0;

        Scanner scanner = new Scanner(System.in);
        while (true && guesses < 3) {
            guesses = guesses + 1 ;
            System.out.print("Please guess the number");
            number = scanner.nextInt();
            if (number == rand)
                System.out.println("You have guessed the number correctly");
            else{
                System.out.println("Incorrect");
            }
            //if (guesses == 3)
            //System.out.println("Complete");
            //break;

        }
        
        System.out.println("You ran out of guesses");

    }
}
