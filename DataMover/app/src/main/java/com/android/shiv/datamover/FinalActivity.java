package com.android.shiv.datamover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by shiv on 12/2/17.
 */

public class FinalActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Bundle extras = getIntent().getExtras();
        textView = (TextView) findViewById(R.id.validationText);
        textView.setText(extras.getString("LoggedIn"));
    }
}
