package com.android.shiv.datamover;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by shiv on 12/2/17.
 */

public class SecondActivity extends AppCompatActivity {

    HashMap<String, String> email = null;
    HashMap<String, String> name = null;
    public static final int RESULT_OK = 2;
    public static final int RESULT_CLEAR = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        email = new HashMap<>();
        email.put("shiv.safari@gmail.com", "123");
        email.put("rakesh@gmail.com", "123");
        email.put("sumitxyz@gmail.com", "123");

        name = new HashMap<>();
        name.put("shiv.safari@gmail.com", "Shiv Pratap Singh");
        name.put("rakesh@gmail.com", "Rakesh Kumar");
        name.put("sumitxyz@gmail.com", "Sumit Kumar");

        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            String[] mailDetails = extras.getStringArray("LoginDetails");
            if(email.containsKey(mailDetails[0])) {
                String pass = email.get(mailDetails[0]);
                if(pass.equals(mailDetails[1])) {
                    Intent i = new Intent(this.getBaseContext(), FinalActivity.class);
                    i.putExtra("LoggedIn", name.get(mailDetails[0]));
                    startActivity(i);
                } else {
                    Intent i = new Intent();
                    i.putExtra("LoginFailed", "Wrong Password");
                    setResult(RESULT_OK, i);
                    finish();
                }
            } else {
                Intent i = new Intent();
                i.putExtra("LoginFailed", "Account Doesn't Exist.");
                setResult(RESULT_OK, i);
                finish();
            }
        }



    }
}
