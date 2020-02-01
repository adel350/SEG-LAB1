package com.example.seg_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsScreenActivity extends AppCompatActivity {

    private Spinner questionSpinner;
    private Spinner gradeSpinner;

    private ArrayAdapter<CharSequence> question_spinner_adapter;
    private ArrayAdapter<CharSequence> grade_spinner_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        //Question number spinner
        questionSpinner = findViewById(R.id.questionspinner);
        question_spinner_adapter = ArrayAdapter.createFromResource(this, R.array.questions_arrays, android.R.layout.simple_spinner_item);
        question_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        questionSpinner.setAdapter(question_spinner_adapter);

        //Passing grade spinner
        gradeSpinner = findViewById(R.id.gradespinner);
        grade_spinner_adapter = ArrayAdapter.createFromResource(this, R.array.passingGrade_arrays, android.R.layout.simple_spinner_item);
        grade_spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeSpinner.setAdapter(grade_spinner_adapter);


        //TODO: set the intial values for the ones in the Settings


//        spinner_adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
//        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(spinner_adapter);
//        spinner.setOnItemSelectedListener(this);
    }

    public void cancelOnClick(View view) {
        questionSpinner.setSelection(0);
        gradeSpinner.setSelection(0);

//        int default_position = spinner_adapter.getPosition(selectedCountry);
//        spinner.setSelection(default_position);
    }

    public void saveOnClick(View view) {
        //Get the selected stuff
        String grade = gradeSpinner.getSelectedItem().toString();
        String question = questionSpinner.getSelectedItem().toString();

        //Update Settings model
        Settings.changePassingGrade(Integer.parseInt(grade));
        Settings.changeNumberOfQuestions(Integer.parseInt(question));

        System.out.println("ADEL2");
        System.out.println(Settings.passingGrade);
        System.out.println(Settings.numberOfQuestions);

    }
}
