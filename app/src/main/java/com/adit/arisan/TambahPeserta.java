package com.adit.arisan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adit.arisan.activity.AnggotaArisann;
import com.adit.arisan.model.Peserta;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class TambahPeserta extends AppCompatActivity {

    EditText tNama,tAlamat,tNomerHp;
    Button btnTambahPeserta,btnKeluar;
    DatabaseReference peserta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_peserta);

        tNama = (EditText) findViewById(R.id.edt_namaPesertaArisan);
        tAlamat =(EditText) findViewById(R.id.edt_AlamatPeserta);
        tNomerHp = (EditText) findViewById(R.id.edt_noHp);
        btnTambahPeserta = (Button) findViewById(R.id.btn_tambah_peserta);
        peserta = FirebaseDatabase.getInstance().getReference("Peserta");
        btnKeluar = (Button) findViewById(R.id.btn_keluar);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AnggotaArisann.class);
                startActivity(intent);
            }
        });
        btnTambahPeserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPeserta();
            }
        });
    }

    private void addPeserta() {
        final String nama = tNama.getText().toString();
        final String noHp = tNomerHp.getText().toString();
        final String alamat = tAlamat.getText().toString();

        if ( nama.isEmpty() || alamat.isEmpty() || noHp.isEmpty()){
            showMessage("Mohon isi semua kolom ");
        }else {
            Peserta tambah = new Peserta(nama,alamat,noHp);
            peserta.child(nama).child("nama").setValue(nama.toString());
            peserta.child(nama).child("noHp").setValue(noHp.toString());
            peserta.child(nama).child("alamat").setValue(alamat.toString());

            Toast.makeText(getApplication(),"Success",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplication(),AnggotaArisann.class);
            startActivity(intent);
        }
        }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
