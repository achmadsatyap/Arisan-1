package com.adit.arisan;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class LoginArisan extends AppCompatActivity{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clickSignUp(View view) {
        Intent intent = new Intent(this,RegisterArisan.class);
        startActivity(intent);
    }

    public void postLogin(View view) {
        Intent intent = new Intent(this,PesertaArisan.class);
        startActivity(intent);
    }
}
