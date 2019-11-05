package com.adit.arisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adit.arisan.activity.Arisann;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahGrup extends AppCompatActivity {

    EditText tNamaGrup,tNominal,tKeterangan;
    Button btnTambahGrup,btnKeluar;
    DatabaseReference gruparisan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_grup);

        tNamaGrup = (EditText) findViewById(R.id.edt_namaArisan);
        tNominal =(EditText) findViewById(R.id.edt_nominal);
        tKeterangan = (EditText) findViewById(R.id.edt_tanggal);
        btnTambahGrup = (Button) findViewById(R.id.btn_tambahGrup);
        btnKeluar = (Button) findViewById(R.id.btn_exit);
        gruparisan = FirebaseDatabase.getInstance().getReference("Grup");

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Arisann.class));
            }
        });
        btnTambahGrup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGrup();
            }
        });
    }

    private void addGrup() {
        final String namaArisan = tNamaGrup.getText().toString();
        final String nominal = tNominal.getText().toString();
        final String keterangan = tKeterangan.getText().toString();

        if ( namaArisan.isEmpty() || keterangan.isEmpty() || nominal.isEmpty()){
            showMessage("Mohon isi semua kolom ");
        }else {
            Grup arisan = new Grup (namaArisan,keterangan,nominal);
            gruparisan.child(namaArisan).child("namaArisan").setValue(namaArisan.toString());
            gruparisan.child(namaArisan).child("keterangan").setValue(keterangan.toString());
            gruparisan.child(namaArisan).child("nominal").setValue(nominal.toString());

            Toast.makeText(getApplication(),"Success",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplication(), Arisann.class);
            startActivity(intent);
        }
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }



    public void keluar(View view) {

    }




}
