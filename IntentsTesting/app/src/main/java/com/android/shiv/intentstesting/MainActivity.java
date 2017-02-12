package com.android.shiv.intentstesting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button toSecondPage;
    String status = "";
    int order = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = "First Page: Activity Created";
        displayStatus();

        toSecondPage = (Button) findViewById(R.id.toSecondPage);
        toSecondPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(v.getContext(), SecondElement.class);
                startActivity(it);
            }

        });

    }

    @Override
    protected void onStart() {
        //activity resumed
        super.onStart();
        status = "First Page: Activity Started";
        displayStatus();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //restoring instance state
        super.onRestoreInstanceState(savedInstanceState);
        status = "First Page: Restoring Instance";
        displayStatus();

    }

    @Override
    protected void onResume() {
        //activity resumed
        super.onResume();
        status = "First Page: Activity Resumed";
        displayStatus();
    }

    @Override
    protected void onPause() {
        //activity paused
        super.onPause();
        status = "First Page: Activity Paused";
        displayStatus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //saving instance state
        super.onSaveInstanceState(outState);
        status = "First Page: Saving Instance";
        displayStatus();

    }

    @Override
    protected void onStop() {
        //activity stopped
        super.onStop();
        status = "First Page: Activity Stopped";
        displayStatus();
    }

    @Override
    protected void onDestroy() {
        //activity destroyed
        super.onDestroy();
        status = "First Page: Activity Destroyed";
        displayStatus();
    }

    @Override
    protected void onRestart() {
        //activity destroyed
        super.onRestart();
        status = "First Page: Activity Restarted";
        displayStatus();
    }

    public void displayStatus(){
        order++;
        String message = String.valueOf(order) + ": " + status;
        //t.setText(status);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
