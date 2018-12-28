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


public class SongsSubTopics extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout Rl;
    Button originalSongs;
    Button singOutJoyfully;
    Button childrenSongs;
    Intent intent;
    int message;
    int songs;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_songs_sub_topics);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

       // setSupportActionBar(toolbar);
        //The categroy that was chosen
        songs=0;
        //Referencing the buttons
        originalSongs = (Button)findViewById(R.id.org_lbl);
        singOutJoyfully = (Button)findViewById(R.id.soj_lbl);
        childrenSongs = (Button)findViewById(R.id.child_lbl);

        //Setting onClickListeners for the buttons
        originalSongs.setOnClickListener(this);
        singOutJoyfully.setOnClickListener(this);
        childrenSongs.setOnClickListener(this);
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
            case R.id.org_lbl:
                //Create the intent
                intent = new Intent(this, QuizActivity.class);

                //theTopic.setText("originalSongs");
                songs=1;
                message = songs;

                // put the text into the intent
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);

                break;
            case R.id.soj_lbl:
                intent = new Intent(this, QuizActivity.class);
                //theTopic.setText("singOutJoyfully");
                songs=2;
                 message = songs;
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);

                break;
            case R.id.child_lbl:
                intent = new Intent(this, QuizActivity.class);
                //
                // theTopic.setText("childrenSongs");
               songs=3;
                message = songs;
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);

        }
    }

}