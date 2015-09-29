package com.example.renato.encuentrameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt;
    Button out;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        out = (Button) findViewById(R.id.btn_logout);

        out.setOnClickListener(this);

        preferences = getSharedPreferences(LoginActivity.PREFERENCE, MODE_PRIVATE);
        editor = preferences.edit();

        txt.setText(preferences.getString(LoginActivity.KEY_USER, ""));

    }


    @Override
    public void onClick(View v) {
        editor.putBoolean(LoginActivity.KEY_LOGIN, false);
        editor.commit();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();

    }
}
