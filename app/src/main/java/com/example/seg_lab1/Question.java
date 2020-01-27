package com.example.seg_lab1;

import java.util.ArrayList;

public class Question {

    private int id;
    private String description;
    private ArrayList <String> options;
    private int correctAnswerId;

    public Question(int id, String description, int correctAnswerId) {
        this.id = id;
        this.description = description;
        this.correctAnswerId = correctAnswerId;
        this.options = new ArrayList<String>();//Empty, options need to be added later
    }

    public int getId() { return this.id;}

    public String getDescription() {return this.description;}

    public int getCorrectAnswerId() { return correctAnswerId;}

    public ArrayList<String> getOptions() {return this.options;}

    public void addOption(String option) {
        this.options.add(option);
    }
}
