package com.example.seg_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.w3c.dom.Text;


public class QuestionScreenActivity extends AppCompatActivity {

    public ArrayList<Question> questions;
    public int questionNumber = 0;//Tracks at which question we're at
    public int numOfQuestionsAnsweredRight = 0;

    private RadioGroup optionsRadioGroup;
    private RadioButton optionRadioButton;

    //protected void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);
        //View rootView = inflater.inflate(R.layout.activity_question_screen, container,    false);
        optionsRadioGroup = findViewById(R.id.rb_group_sort_types);


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

        //Check if an answer is selected first, if not then display an error message
        TextView errorMessage = (TextView) findViewById(R.id.text_error_message);
        if (optionsRadioGroup.getCheckedRadioButtonId() == -1)
            errorMessage.setVisibility(View.VISIBLE);
        else {
            errorMessage.setVisibility(View.INVISIBLE);
            //Check if correct answer
            int radioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
            optionRadioButton = findViewById(radioButtonId);
            int selectedIndex = optionsRadioGroup.indexOfChild(optionRadioButton);

            if ((selectedIndex+1) == questions.get(questionNumber-1).getCorrectAnswerId())
                numOfQuestionsAnsweredRight++;




            //Check if we should display the results or not
            if (questionNumber == Settings.numberOfQuestions)
                goToSummaryScreen(findViewById(android.R.id.content).getRootView());
            else {
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

                optionsRadioGroup.clearCheck();
            }

        }




    }

    public void goToSummaryScreen(View view) {
        Intent intent = new Intent(this, SummaryScreenActivity.class);
        intent.putExtra("correctQuestions", numOfQuestionsAnsweredRight); //passing the questions array to the next activity
        startActivity(intent);
    }
}
