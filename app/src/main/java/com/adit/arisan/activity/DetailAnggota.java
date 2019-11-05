package com.adit.arisan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adit.arisan.Peserta;
import com.adit.arisan.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class DetailAnggota extends AppCompatActivity {

    DatabaseReference databaseReference;

    TextView TextNama, TextNotlp, TextAlamat;
    Button TombolKeluar;
    private String concatNama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anggota);

        TextNama = findViewById(R.id.edt_DetailPesertaArisan);
        TextAlamat = findViewById(R.id.edt_DetailAlamatPeserta);
        TextNotlp = findViewById(R.id.edt_DetailHp);

        TombolKeluar = findViewById(R.id.btn_keluarDetail);

        databaseReference = FirebaseDatabase.getInstance().getReference("Peserta");
        concatNama = getIntent().getExtras().getString("nama");
        redData();
        TombolKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AnggotaArisann.class));
            }
        });

    }

    private void redData() {
        Query findQuery = databaseReference.orderByKey().equalTo(concatNama);

        findQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot getSnapshot : dataSnapshot.getChildren()){
                    TextNama.setText(getSnapshot.child("nama").getValue().toString());
                    TextNotlp.setText(getSnapshot.child("noHp").getValue().toString());
                    TextAlamat.setText(getSnapshot.child("alamat").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
