package com.example.renato.encuentrameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Created by RENATO on 28/09/2015.
 */
public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences(LoginActivity.PREFERENCE, MODE_PRIVATE);

        boolean login = preferences.getBoolean(LoginActivity.KEY_LOGIN, false);
        Intent intent = null;

        if(login)
            intent = new Intent(this, MainActivity.class);
        else
            intent =  new Intent(this, LoginActivity.class);

        startActivity(intent);
    }
}
