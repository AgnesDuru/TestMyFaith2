package com.example.agnes.testmyfaith;
import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MoviesSubTopics extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE_TWO = new String();
    RelativeLayout Rl;
    Button theDocumentary;
    Button modernDay;
    Button bibleTimes;
    Intent intent;
    int movieMessage;
    int movies;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movies_sub_topics);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // setSupportActionBar(toolbar);
        //The categroy that was chosen
        movies=0;
        //Referencing the buttons
        theDocumentary = (Button)findViewById(R.id.documentary_lbl);
        modernDay = (Button)findViewById(R.id.modern_day_lbl);
        bibleTimes = (Button)findViewById(R.id.bible_times_lbl);

        //Setting onClickListeners for the buttons
        theDocumentary.setOnClickListener(this);
        modernDay.setOnClickListener(this);
        bibleTimes.setOnClickListener(this);
        /**
         FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

         fab.setOnClickListener(new View.OnClickListener() {

        @Override

        public void onClick(View view) {

        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)

        .setAction("Action", null).show();

        }

        });



         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         **/


    }

    //Starts a new activity based on the sub category chosen
    //Also changes the text of the quiz activity so that it can be referenced to change the layout and question list of the sub category that was chosen
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.modern_day_lbl:
                //Create the intent
                intent = new Intent(this, QuizActivity.class);

                //theTopic.setText("originalSongs");
                movies=1;
                movieMessage = movies;
                // put the text into the intent
                intent.putExtra(EXTRA_MESSAGE_TWO, movieMessage);
                startActivity(intent);

                break;
            case R.id.documentary_lbl:
                intent = new Intent(this, QuizActivity.class);
                //theTopic.setText("singOutJoyfully");
                movies=2;
                movieMessage = movies;
                intent.putExtra(EXTRA_MESSAGE_TWO, movieMessage);
                startActivity(intent);

                break;
            case R.id.bible_times_lbl:
                intent = new Intent(this, QuizActivity.class);
                //
                // theTopic.setText("childrenSongs");
                movies=3;
                movieMessage = movies;
                intent.putExtra(EXTRA_MESSAGE_TWO, movieMessage);
                startActivity(intent);

        }
    }

}