package com.example.seg_lab1;

public class Settings {

    public static int passingGrade = 50;
    public static int numberOfQuestions = 10;

    public static void changePassingGrade(int grade) {
        passingGrade = grade;
    }

    public static void changeNumberOfQuestions (int number) {
        numberOfQuestions = number;
    }
}
