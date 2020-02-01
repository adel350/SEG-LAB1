package com.example.seg_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import android.widget.TextView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class QuestionScreenActivity extends AppCompatActivity {

    public ArrayList<Question> questions;
    public int questionNumber = 0;//Tracks at which question we're at

    //protected void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);
        //View rootView = inflater.inflate(R.layout.activity_question_screen, container,    false);


        questions = (ArrayList<Question>) getIntent().getSerializableExtra("questionsList") ;

        //Populating the texts
        TextView questionDescription = (TextView) findViewById(R.id.question_description);
        TextView option1 = (TextView) findViewById(R.id.rbutton_option1);
        TextView option2 = (TextView) findViewById(R.id.rbutton_option2);
        TextView option3 = (TextView) findViewById(R.id.rbutton_option3);
        TextView option4 = (TextView) findViewById(R.id.rbutton_option4);

        questionDescription.setText(questions.get(0).getDescription());
        option1.setText(questions.get(0).getOptions().get(0));
        option2.setText(questions.get(0).getOptions().get(1));
        option3.setText(questions.get(0).getOptions().get(2));
        option4.setText(questions.get(0).getOptions().get(3));

        //increase questionNumber after displaying the first
        questionNumber++;
    }

    public void submitOnClick(View view) {
        //Display next question or results

        //Populating the texts
        TextView questionDescription = (TextView) findViewById(R.id.question_description);
        TextView option1 = (TextView) findViewById(R.id.rbutton_option1);
        TextView option2 = (TextView) findViewById(R.id.rbutton_option2);
        TextView option3 = (TextView) findViewById(R.id.rbutton_option3);
        TextView option4 = (TextView) findViewById(R.id.rbutton_option4);

        questionDescription.setText(questions.get(questionNumber).getDescription());
        option1.setText(questions.get(questionNumber).getOptions().get(0));
        option2.setText(questions.get(questionNumber).getOptions().get(1));
        option3.setText(questions.get(questionNumber).getOptions().get(2));
        option4.setText(questions.get(questionNumber).getOptions().get(3));

        questionNumber++;



//        Intent intent = new Intent(this, QuestionScreenActivity.class);
//        intent.putExtra("questionsList", questions); //passing the questions array to the next activity
//        startActivity(intent);
    }
}
