package com.example.seg_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class QuestionScreenActivity extends AppCompatActivity {

    public ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);


        questions = (ArrayList<Question>) getIntent().getSerializableExtra("questionsList") ;
        
    }
}
