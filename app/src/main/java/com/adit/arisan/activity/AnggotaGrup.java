package com.adit.arisan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.adit.arisan.HasilArisan;
import com.adit.arisan.PilihPeserta;
import com.adit.arisan.R;
import com.adit.arisan.TambahPeserta;
import com.adit.arisan.model.HasilArisann;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AnggotaGrup extends AppCompatActivity {

    DatabaseReference anggotaGrup;
    TextView tNama;
    private String arisanNama,nama;
    ArrayAdapter<String> arrayAdapter;
    HasilArisann hasilArisann;
    ArrayList<String> namaA;

//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.keluar, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.keluar_nav:
                startActivity(new Intent(getApplication(), DetailGrup.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota_grup);


        anggotaGrup = FirebaseDatabase.getInstance().getReference("HasilArisann");
        tNama = findViewById(R.id.nama_Arisan);
        namaA = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_anggota_grup,R.id.nama_Arisan,namaA);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab_hasil);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PilihPeserta.class));
            }
        });

    }

    


}
