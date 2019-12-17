package com.adit.arisan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.adit.arisan.R;
import com.adit.arisan.TambahPeserta;
import com.adit.arisan.model.Peserta;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AnggotaArisann extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private ListView listView;
    ArrayAdapter<String> arrayAdapter;
//    Model module;
    ArrayList<String> pesertaList;
//    List<Peserta> pesertaList;
    Peserta peserta;
    public static final String PREFS_NAME = "LoginPrefs";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.peserta_nav:
//                startActivity(new Intent(getApplication(), AnggotaArisann.class));
//                return true;
            case R.id.arisan_nav:
                startActivity(new Intent(getApplication(),Arisann.class));
                return true;
            case R.id.keluar_nav:
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.remove("logged");
                editor.commit();
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota_arisan);
//        module =((Model)getApplicationContext());
        databaseReference = FirebaseDatabase.getInstance().getReference("Peserta");
        listView = (ListView) findViewById(R.id.listviewtxt);
        pesertaList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.peserta_info,R.id.pesertaInfo,pesertaList);
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AnggotaArisann.this, DetailAnggota.class);
                intent.putExtra("nama", listView.getItemAtPosition(i).toString());
                startActivity(intent);
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
