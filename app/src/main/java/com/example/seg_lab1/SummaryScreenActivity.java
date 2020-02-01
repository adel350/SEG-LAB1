package com.example.seg_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SummaryScreenActivity extends AppCompatActivity {

    private int numOfQuestionsAnsweredRight =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_screen);
        numOfQuestionsAnsweredRight = getIntent().getIntExtra("correctQuestions",0);

        //Get textview
        TextView questionDescription = (TextView) findViewById(R.id.summary_results);
        ImageView bottomImage = (ImageView) findViewById(R.id.results_picture);

        //Claculate result
        int finalScore = (numOfQuestionsAnsweredRight*100)/Settings.numberOfQuestions;

        String result1 = String.format("You answered %d question(s) right out of %d. You obtained %d/100! You have passed the simulation exam", numOfQuestionsAnsweredRight, Settings.numberOfQuestions, finalScore);
        String result2 = String.format("You answered %d question(s) right out of %d. You obtained %d/100! You have failed the simulation exam", numOfQuestionsAnsweredRight, Settings.numberOfQuestions, finalScore);

        if (finalScore >= Settings.passingGrade){
            questionDescription.setText(result1);
            bottomImage.setImageResource(R.drawable.pass_banner);
        }
        else {
            questionDescription.setText(result2);
            bottomImage.setImageResource(R.drawable.fail_banner);
        }
    }

    public void goToMainScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
