package com.adit.arisan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomArisan extends AppCompatActivity{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
    }

    public void clickLogin(View view) {
        Intent intent = new Intent(this, LoginArisan.class);
        startActivity(intent);
    }
}
