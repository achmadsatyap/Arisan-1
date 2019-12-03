package com.adit.arisan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.adit.arisan.R;
import com.adit.arisan.TambahGrup;
import com.adit.arisan.model.Grup;
import com.adit.arisan.model.HasilArisann;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Arisann extends AppCompatActivity {


    DatabaseReference databaseReference, arisanHasil;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    //    Model module;
    ArrayList<String> grupList;
    TextView textArisan;
    //    List<Peserta> pesertaList;
    HasilArisann hasilArisann;
    Grup grup;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.peserta_nav:
                startActivity(new Intent(getApplication(), AnggotaArisann.class));
                return true;
            case R.id.arisan_nav:
                startActivity(new Intent(getApplication(),Arisann.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arisan);
        textArisan = (TextView) findViewById(R.id.pesertaInfo);
        arisanHasil = FirebaseDatabase.getInstance().getReference("HasilArisann");
        databaseReference = FirebaseDatabase.getInstance().getReference("Grup");
        listView = (ListView) findViewById(R.id.listviewtxt);
        grupList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.peserta_info,R.id.pesertaInfo,grupList);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    grup = postSnapshot.getValue(Grup.class);
                    grupList.add(grup.getNamaArisan());
                }
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                addArisan();
                Intent intent = new Intent(Arisann.this, DetailGrup.class);
                intent.putExtra("namaArisan", listView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), TambahGrup.class));
            }
        });
    }

//    private void addArisan() {
//        final String namaArisan = textArisan.getText().toString();
//        final String nominal = textArisan.getText().toString();
//        final String keterangan = textArisan.getText().toString();
//        HasilArisann hasilArisann = new HasilArisann(namaArisan,nominal,keterangan);
//        arisanHasil.child(namaArisan).child("namaArisan").setValue(namaArisan.toString());
//        arisanHasil.child(namaArisan).child("keterangan").setValue(keterangan.toString());
//        arisanHasil.child(namaArisan).child("nominal").setValue(nominal.toString());
//    }
}
