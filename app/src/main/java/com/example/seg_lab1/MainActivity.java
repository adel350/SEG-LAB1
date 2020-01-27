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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadJSONFromAsset();
        System.out.println("ADEL HI");
        System.out.println(loadJSONFromAsset());
        populateData();

        //Populate all questions and settings scheme HERE
    }

    public void testOnClick(View view) {
        Intent intent = new Intent(this, QuestionScreenActivity.class);
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
            JSONArray m_jArry = obj.getJSONArray("questions");
            ArrayList<HashMap<String, String>> questionList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            System.out.println("Adel");
            System.out.println(m_jArry.length());

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                //Log.d("Details-->", jo_inside.getString("formule"));
                int formula_value = jo_inside.getInt("id");
                String url_value = jo_inside.getString("title");

//                //Add your values in your `ArrayList` as below:
//                m_li = new HashMap<String, String>();
//                m_li.put("formule", formula_value);
//                m_li.put("url", url_value);
//
//                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
