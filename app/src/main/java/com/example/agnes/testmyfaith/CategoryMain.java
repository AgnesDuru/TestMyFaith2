package com.example.agnes.testmyfaith;


import android.content.Intent;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.Snackbar;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;

import android.view.MenuItem;


import android.content.Intent;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;

import android.view.View;

import android.view.Menu;

import android.view.MenuItem;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import android.content.Intent;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;

import android.view.View;

import android.view.Menu;

import android.view.MenuItem;

import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class CategoryMain extends AppCompatActivity implements View.OnClickListener {

Button theMovies;
Button theSongs;
Button children;
Button theBible;
Button broadcast;
Button organization;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setSupportActionBar(toolbar);

        theMovies=(Button)findViewById(R.id.movie_lbl);
theSongs=(Button)findViewById(R.id.song_lbl);
children=(Button)findViewById(R.id.children_lbl);
theBible=(Button)findViewById(R.id.the_bible_lbl);
broadcast=(Button)findViewById(R.id.broadcast_btn);
organization=(Button)findViewById(R.id.oragnization_btn);


        theMovies.setOnClickListener(this);
        theSongs.setOnClickListener(this);
        theBible.setOnClickListener(this);
        broadcast.setOnClickListener(this);
        organization.setOnClickListener(this);


      //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

       // fab.setOnClickListener(new View.OnClickListener() {
/**
            @Override

            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)

                        .setAction("Action", null).show();

            }

        });

            **/
    }



    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_category_main, menu);

        return true;

    }



    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will

        // automatically handle clicks on the Home/Up button, so long

        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();



        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings) {

            return true;

        }



        return super.onOptionsItemSelected(item);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        //The song category option
            case R.id.song_lbl:
                //Create the intent
                Intent intent = new Intent(this, SongsSubTopics.class);
                startActivity(intent);
                break;

            case R.id.movie_lbl:
                //Create the intent
                Intent movieIntent = new Intent(this, MoviesSubTopics.class);
                startActivity(movieIntent);
break;
        }
}
}