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
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_LOGIN="login";
    public static final String KEY_USER="user";

    public static final String PREFERENCE="preference";

    EditText usr2, pass2;
    Button in3;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usr2 = (EditText) findViewById(R.id.usr2);
        pass2 = (EditText) findViewById(R.id.pass2);

        in3 = (Button) findViewById(R.id.btn1);

        in3.setOnClickListener(this);

        preferences = getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        editor =preferences.edit();

    }


    @Override
    public void onClick(View v) {
        editor.putBoolean(KEY_LOGIN, true);
        editor.putString(KEY_USER, usr2.getText().toString());
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
