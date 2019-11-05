package com.adit.arisan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class PilihPeserta extends AppCompatActivity {
//    private OnFragmentInteractionListener mListener;

    private DatabaseReference databaseReference;
    private ListView listView;
    ArrayAdapter<String> arrayAdapter;
    //    Model module;
    ArrayList<String> pesertaList;
    //    List<Peserta> pesertaList;
    Peserta peserta;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_peserta);
        databaseReference = FirebaseDatabase.getInstance().getReference("Peserta");
        listView = (ListView) findViewById(R.id.listPilih);
        pesertaList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.check_peserta,R.id.namaCheck,pesertaList);
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
    }
}
