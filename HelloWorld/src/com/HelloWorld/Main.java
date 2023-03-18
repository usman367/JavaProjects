package com.HelloWorld;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        final byte monthsInYear = 12;
        final byte percent = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Principal (£1k - £1M):");
            principal = scanner.nextInt();
            //System.out.println("Your Principal is:" + principal);
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a va lue between £1000 and 1,000,000");
        }

        Scanner scanner2 = new Scanner(System.in);
        while (true) {
            System.out.print("Annual Interest rate:");
            float annualInterest = scanner2.nextFloat();
            //System.out.println("Your Annual Interest is:" + annualInterest);
            if (annualInterest >= 1 && annualInterest <= 30)
                break;
            monthlyInterest = annualInterest / percent / monthsInYear;
            System.out.println("Enter a value between 1 and 30");
        }

        Scanner scanner3 = new Scanner(System.in);
        while (true) {
            System.out.print("Period:");
            byte years = scanner3.nextByte();
            //System.out.println("Your period is:" + period);
            if (years >= 1 && years <= 30)
                //numberOfPayments = years * monthsInYear;
                break;
            numberOfPayments = years * monthsInYear;
            System.out.println("Enter a value between 1 and 30");
        }


        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);


//String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage); OR:
        NumberFormat mortgageFormatted = NumberFormat.getCurrencyInstance();
        String result = mortgageFormatted.format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}
