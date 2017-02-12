package com.android.shiv.datamover;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int DETAIL_REQUEST = 1;

    EditText mailIdText;
    EditText mailPassText;
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mailIdText = (EditText) findViewById(R.id.mailIdText);
        mailPassText = (EditText) findViewById(R.id.mailPassText);

        signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SecondActivity.class);
                String[] mailDetails = new String[2];
                mailDetails[0] = mailIdText.getText().toString();
                mailDetails[1] = mailPassText.getText().toString();

                i.putExtra("LoginDetails", mailDetails);
                startActivityForResult(i, DETAIL_REQUEST);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            if(data.hasExtra("LoginFailed")) {
                String returnString = data.getExtras().getString("LoginFailed");
                Toast.makeText(this, returnString, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
