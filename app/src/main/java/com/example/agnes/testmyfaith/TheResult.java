package com.example.agnes.testmyfaith;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.example.agnes.testmyfaith.QuizActivity.myScore;
import static com.example.agnes.testmyfaith.QuizActivity.numCorrect;

import com.example.agnes.testmyfaith.R;

public class TheResult extends AppCompatActivity {

    TextView theScore;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        theScore= (TextView)findViewById(R.id.userScore);
        theScore.setText( " " + myScore + " and got " + numCorrect +"/ 10 correct");
    }
}