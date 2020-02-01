package com.example.seg_lab1;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private int id;
    private String title;
    private ArrayList <String> options;
    private int correctAnswerId;

    public Question(int id, String title, int correctAnswerId) {
        this.id = id;
        this.title = title;
        this.correctAnswerId = correctAnswerId;
        this.options = new ArrayList<String>();//Empty, options need to be added later
    }

    public int getId() { return this.id;}

    public String getDescription() {return this.title;}

    public int getCorrectAnswerId() { return correctAnswerId;}

    public ArrayList<String> getOptions() {return this.options;}

    public void addOption(String option) {
        this.options.add(option);
    }
}
