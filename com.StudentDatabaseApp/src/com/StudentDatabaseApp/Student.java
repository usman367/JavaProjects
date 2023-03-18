package com.StudentDatabaseApp;

import java.util.Scanner;

public class Student {
    String firstName ="";
    String lastName = "";
    int year;
    int studentID;
    String courses = "";
    int tuitionBalance = 0;
    static int costOfCourse = 600; //a single copy of static variable is created and shared among all the instances of the class
    static int  id = 10000;

    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your first name:");
        this.firstName =  in.next();

        System.out.print("Please enter your last name:");

        this.lastName =  in.next();
        System.out.print("Please enter your class year:");
        this.year =  in.nextInt();

        setStudentID();

        System.out.println("Your name is: " + firstName + " "  + lastName + " and you are in year " + year + " of university and your Student ID is " + studentID);
    }

    private void setStudentID() {
        id ++;
        this.studentID =  year + id;
    }

    //public void enroll() {
    // loop. User enters 0 when finished enrolling
    //do {
    //System.out.println("Enter course to enroll (0 to quit):");
    //Scanner in = new Scanner(System.in);
    //String course =  in.next();
    //if (course != "Q" || course != "q") {
    //  courses = courses + course;
    //tuitionBalance = tuitionBalance + costOfCourse;
    //}
    //else(break);
    //while(true);
    //}
    //System.out.println("Enrolled In " + courses);
    //System.out.println("Tuition Balance:" + tuitionBalance);
    //}

    public void enroll() {
        System.out.print("Enter course to enroll (Q to quit):");
        Scanner in = new Scanner(System.in);
        String course = in.next();
        while (course != "Q" || course != "q") {
            //if (course != "Q" || course != "q") {
            courses = courses + ", " + course;
            tuitionBalance = tuitionBalance + costOfCourse;
            //}
            if ( course.equals("Q") || course.equals("q")) {
                break;
            }
            System.out.println("Enrolled In" + courses);
            //System.out.println("Tuition Balance:" + tuitionBalance);
            System.out.print("Enter course to enroll (Q to quit):");
            course = in.next();
        }
        System.out.println("Tuition Balance:" + tuitionBalance);
    }

    public void viewBalance() {

        System.out.println("Your balance is £" + tuitionBalance);
    }

    public void payTuition (int payment) {
        Scanner in = new Scanner (System.in);
        System.out.print("Enter your payment");
        payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of " + payment);
        viewBalance();
    }

    public  String showInfo() {
        return "Name: " + firstName + " " + lastName +
                "\nUniversity year: " + year +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled:" + courses +
                "\nbalance: £" + tuitionBalance;
    }
}

