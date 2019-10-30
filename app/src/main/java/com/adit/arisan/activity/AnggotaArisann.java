package com.adit.arisan.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.adit.arisan.Module;
import com.adit.arisan.Peserta;
import com.adit.arisan.R;
import com.adit.arisan.TambahPeserta;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AnggotaArisann extends AppCompatActivity {

    DatabaseReference databaseReference;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
//    Module module;
    ArrayList<String> pesertaList;
//    List<Peserta> pesertaList;
    Peserta peserta;
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
        setContentView(R.layout.activity_anggota_arisan);
//        module =((Module)getApplicationContext());
        databaseReference = FirebaseDatabase.getInstance().getReference("Peserta");
        listView = (ListView) findViewById(R.id.listviewtxt);
        pesertaList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.peserta_info,R.id.pesertaInfo,pesertaList);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    peserta = postSnapshot.getValue(Peserta.class);
                    pesertaList.add(peserta.getNama().toString());
                }
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

         FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.fab2);
         floatingActionButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(getApplicationContext(), TambahPeserta.class));
             }
         });
    }
}
