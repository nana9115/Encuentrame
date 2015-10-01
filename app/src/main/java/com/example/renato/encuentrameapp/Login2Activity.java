package com.example.renato.encuentrameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by RENATO on 28/09/2015.
 */
public class Login2Activity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_LOGIN="login";
    public static final String KEY_USER="user";

    public static final String PREFERENCE="preference";

    EditText usr1, pass1;
    Button in1, in2;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        usr1 = (EditText) findViewById(R.id.usr1);
        pass1 = (EditText) findViewById(R.id.pass1);

        in1 = (Button) findViewById(R.id.btn1);
        in2 = (Button) findViewById(R.id.btn2);

        in1.setOnClickListener(this);
        in2.setOnClickListener(this);

        preferences = getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        editor =preferences.edit();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn1:

                editor.putBoolean(KEY_LOGIN, true);
                editor.putString(KEY_USER, usr1.getText().toString());
                editor.commit();

                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);


            break;

            case R.id.btn2:

                Intent intent2 = new Intent(this, LoginActivity.class);
                startActivity(intent2);


           break;
        }
    }



}
