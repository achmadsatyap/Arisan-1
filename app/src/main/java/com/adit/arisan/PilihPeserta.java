package com.adit.arisan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.adit.arisan.activity.AnggotaGrup;
import com.adit.arisan.model.HasilArisann;
import com.adit.arisan.model.Peserta;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class PilihPeserta extends AppCompatActivity {
//    private OnFragmentInteractionListener mListener;
    TextView tArisan;
    private DatabaseReference databaseReference,detailArisan,arisanGrup;
    private ListView listView;
    ArrayAdapter<String> arrayAdapter;
    //    Model module;
    ArrayList<String> pesertaList;
    //    List<Peserta> pesertaList;
    CheckBox checkPeserta;
    Peserta peserta;
    Button btnSimpan;
    private String namaGrup;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_peserta);
        checkPeserta = findViewById(R.id.CheckPeserta);
        detailArisan = FirebaseDatabase.getInstance().getReference("HasilArisann");
        databaseReference = FirebaseDatabase.getInstance().getReference("Peserta");
        detailArisan = FirebaseDatabase.getInstance().getReference("HasilArisann");
        namaGrup = getIntent().getExtras().getString("namaArisan");
        listView = (ListView) findViewById(R.id.listPilih);
        pesertaList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.check_peserta,R.id.CheckPeserta,pesertaList);
        readData();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    peserta = postSnapshot.getValue(Peserta.class);
                    pesertaList.add(peserta.getNama());
                }
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnSimpan = (Button) findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view) {
                addPeserta();
                Intent intent = new Intent(getApplicationContext(), AnggotaGrup.class);
                startActivity(intent);
            }
        });
    }

    private void readData() {
        Query findByQuery = arisanGrup.orderByKey().equalTo(namaGrup);
        findByQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnap : dataSnapshot.getChildren()){
                    tArisan.setText(postSnap.child("namaArisan").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void addPeserta() {
        final String namaPeserta1 = checkPeserta.getText().toString();
        final String namaPeserta2 = checkPeserta.getText().toString();
        final String namaPeserta3 = checkPeserta.getText().toString();
        final String namaPeserta4 = checkPeserta.getText().toString();
        final String namaPeserta5 = checkPeserta.getText().toString();
        final String namaPeserta6 = checkPeserta.getText().toString();
        final String namaPeserta7 = checkPeserta.getText().toString();
        final String namaPeserta8 = checkPeserta.getText().toString();
        final String namaPeserta9 = checkPeserta.getText().toString();
        final String namaPeserta10 = checkPeserta.getText().toString();

        HasilArisann hasilArisann = new HasilArisann(namaPeserta1,namaPeserta2,namaPeserta3,namaPeserta4,namaPeserta5,
                namaPeserta6,namaPeserta7,namaPeserta8,namaPeserta9,namaPeserta10);
//        detailArisan.child()
    }
}
