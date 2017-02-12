package com.android.shiv.intentstesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by shiv on 12/2/17.
 */

public class SecondElement extends AppCompatActivity {

    Button toFirstPage;
    String status = "";
    int order = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        status = "Second Page: Activity Created";
        displayStatus();

        toFirstPage = (Button) findViewById(R.id.toSecondPage);
        toFirstPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(v.getContext(), MainActivity.class);
                startActivity(it);
            }

        });

    }


    @Override
    protected void onStart() {
        //activity resumed
        super.onStart();
        status = "Second Page: Activity Started";
        displayStatus();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //restoring instance state
        super.onRestoreInstanceState(savedInstanceState);
        status = "Second Page: Restoring Instance";
        displayStatus();

    }

    @Override
    protected void onResume() {
        //activity resumed
        super.onResume();
        status = "Second Page: Activity Resumed";
        displayStatus();
    }

    @Override
    protected void onPause() {
        //activity paused
        super.onPause();
        status = "Second Page: Activity Paused";
        displayStatus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //saving instance state
        super.onSaveInstanceState(outState);
        status = "Second Page: Saving Instance";
        displayStatus();

    }

    @Override
    protected void onStop() {
        //activity stopped
        super.onStop();
        status = "Second Page: Activity Stopped";
        displayStatus();
    }

    @Override
    protected void onDestroy() {
        //activity destroyed
        super.onDestroy();
        status = "Second Page: Activity Destroyed";
        displayStatus();
    }

    @Override
    protected void onRestart() {
        //activity destroyed
        super.onRestart();
        status = "Second Page: Activity Restarted";
        displayStatus();
    }

    public void displayStatus(){
        order++;
        String message = String.valueOf(order) + ": " + status;
        //t.setText(status);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}
