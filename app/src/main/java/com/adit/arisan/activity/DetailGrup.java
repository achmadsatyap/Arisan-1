package com.adit.arisan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adit.arisan.PilihPeserta;
import com.adit.arisan.R;
import com.adit.arisan.TambahGrup;
import com.adit.arisan.model.HasilArisann;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DetailGrup extends AppCompatActivity {

    DatabaseReference databaseReference, detailArisan;

    TextView textArisan, textNominal, textKeterangan;
    Button Kocok, History, Anggota;
    private boolean isBaru;

    private String NamaGrup, NamaPeserta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_arisan);

        textArisan = findViewById(R.id.text_namaArisan);
        textNominal = findViewById(R.id.text_nominal);
        textKeterangan = findViewById(R.id.text_tanggal);

        Kocok = findViewById(R.id.btn_keluar);
        History = findViewById(R.id.btn_history);
        Anggota = findViewById(R.id.btn_tampilAnggotaGrup);

        databaseReference = FirebaseDatabase.getInstance().getReference("Grup");
        detailArisan = FirebaseDatabase.getInstance().getReference("HasilArisann");
//        NamaPeserta = getIntent().getExtras().getString("nama");
        NamaGrup = getIntent().getExtras().getString("namaArisan");
//        NamaPeserta = getIntent().getExtras().getString("nama");
        redData();

        Anggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
                startActivity(new Intent(getApplicationContext(),AnggotaGrup.class));
            }
        });


    }

    private void redData() {
        Query findByQuery = databaseReference.orderByKey().equalTo(NamaGrup);
        findByQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot getSnapshot : dataSnapshot.getChildren()) {
                    textArisan.setText(getSnapshot.child("namaArisan").getValue().toString());
                    textNominal.setText(getSnapshot.child("nominal").getValue().toString());
                    textKeterangan.setText(getSnapshot.child("keterangan").getValue().toString());
//                        textPeserta.setText(getSnapshot.child("nama").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void addData() {
        final String namaArisan = textArisan.getText().toString();
        final String nominal = textNominal.getText().toString();
        final String keterangan = textKeterangan.getText().toString();
        HasilArisann hasilArisann = new HasilArisann(namaArisan);
        detailArisan.child(namaArisan).child("namaArisan").setValue(namaArisan);
//        detailArisan.child(namaArisan).child("nominal").setValue(nominal);
//        detailArisan.child(namaArisan).child("keterangan").setValue(keterangan);

    }



}

