package com.adit.arisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TambahGrup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_grup);
    }

    public void keluar(View view) {
    }

    public void TambahGrup(View view) {
    }

    public void tambah(View view) {
        Intent intent = new Intent(this, TambahGrup.class);
        startActivity(intent);
    }
}
