package com.example.agnes.testmyfaith;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import javax.xml.transform.Result;

public class Welcome extends Activity implements View.OnClickListener {
Button nextPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        nextPageBtn = (Button)findViewById(R.id.log_in_btn);
        nextPageBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==nextPageBtn.getId()){
            Intent intent = new Intent(this, CategoryMain.class);
            startActivity(intent);
        }
    }
}