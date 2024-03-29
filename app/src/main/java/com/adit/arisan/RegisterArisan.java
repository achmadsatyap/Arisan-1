package com.adit.arisan;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.String;

import com.adit.arisan.model.Security;
import com.adit.arisan.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterArisan extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

     EditText etUsername, etNama, etPassword, etAlamat, etEmail;
    Button regbtn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        etUsername = findViewById(R.id.edit_username);
        etNama = findViewById(R.id.edt_name);
        etPassword = findViewById(R.id.edt_password);
        etAlamat = findViewById(R.id.edt_alamat);
        etEmail = findViewById(R.id.edt_email);
        regbtn = findViewById(R.id.btn_req);
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addUser();


    }

    private void addUser() {
        final String username = etUsername.getText().toString();
        final String nama = etNama.getText().toString();
        final String password = etPassword.getText().toString();
        final String alamat = etAlamat.getText().toString();
        final String email = etEmail.getText().toString();

        if (username.isEmpty() || nama.isEmpty() || password.isEmpty() || alamat.isEmpty() || email.isEmpty()){
            showMessage("Mohon isi semua kolom ");
        }else {
            User user= new User(username,nama,password,email,alamat);
            databaseReference.child(username).child("username").setValue(username.toString());
            databaseReference.child(username).child("nama").setValue(nama.toString());
            databaseReference.child(username).child("email").setValue(email.toString());
            databaseReference.child(username).child("alamat").setValue(alamat.toString());
            try {
                databaseReference.child(username).child("password").setValue(Security.encrypt(password));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplication(),"Success",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplication(),LoginArisan.class);
            startActivity(intent);
        }
    }
        });
    }


    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if User is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//
//    }
}
