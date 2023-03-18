package com.StudentDatabaseApp;

import java.util.Scanner;


//https://www.youtube.com/watch?v=GOGt7PACl10&list=PLvxuqxA4YloD_0xkY6QYpA9PwZ4WeT-Ut&index=7&t=0s

public class StudentDatabaseApp {
    public static void main(String[] args) {
        //Student stu1 = new Student();
//stu1.enroll();
//stu1.payTuition(500);
//System.out.println(stu1.showInfo()); //stu1.showInfo(); Doesn't display student ID

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the number of students you want to enroll:");
        int numOfStudents = in.nextInt();
        Student[] students = new Student[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            students [i] = new Student();
            students [i].enroll();
            students [i].payTuition(100);
            //System.out.println(students[i].showInfo()); //stu1.showInfo(); Doesn't display student ID
        }

        for (int i = 0; i < numOfStudents; i++) {
            System.out.println(students[i].showInfo());
        }
    }
}
