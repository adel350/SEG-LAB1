package com.example.seg_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.HashMap;
import java.util.ArrayList;
import android.util.Log;



public class MainActivity extends AppCompatActivity {

    //Array list of questions that will be populated here
    public ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        loadJSONFromAsset();
//        System.out.println("ADEL HI");
//        System.out.println(loadJSONFromAsset());

        questions = new ArrayList<Question>();
        populateData();

        //Populate all questions and settings scheme HERE
    }

    public void testOnClick(View view) {
        Intent intent = new Intent(this, QuestionScreenActivity.class);
        startActivity(intent);
    }
    public void settingsOnClick(View view){
        Intent intent = new Intent(this,SettingsScreenActivity.class);
        startActivity(intent);
    }


//Method to return the JSON stored in assets as a String
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("db.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void populateData() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray questionArray = obj.getJSONArray("questions");
            JSONArray optionsArray = obj.getJSONArray("choices");
//            ArrayList<HashMap<String, String>> questionList = new ArrayList<HashMap<String, String>>();
//            HashMap<String, String> m_li;



            for (int i = 0; i < questionArray.length(); i++) {
                JSONObject jo_inside = questionArray.getJSONObject(i);
                //Log.d("Details-->", jo_inside.getString("formule"));
                int question_id = jo_inside.getInt("id");
                String title = jo_inside.getString("title");
                int correctAnswerId = jo_inside.getInt("correctAnswerId");

                Question newQuestion = new Question(question_id, title, correctAnswerId);
                questions.add(newQuestion);


                //For each question, add the corresponding options


//                //Add your values in your `ArrayList` as below:
//                m_li = new HashMap<String, String>();
//                m_li.put("formule", formula_value);
//                m_li.put("url", url_value);
//
//                formList.add(m_li);
            }

            //Add the options now for each question
            for (int j=0; j < optionsArray.length(); j++) {
                JSONObject jo_option_inside = questionArray.getJSONObject(j);

                String option1 = jo_option_inside.getString("option1");
                String option2 = jo_option_inside.getString("option2");
                String option3 = jo_option_inside.getString("option3");
                String option4 = jo_option_inside.getString("option4");

                questions.get(j).addOption(option1);
                questions.get(j).addOption(option2);
                questions.get(j).addOption(option3);
                questions.get(j).addOption(option4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
