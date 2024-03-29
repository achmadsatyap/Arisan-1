package com.adit.arisan;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adit.arisan.activity.AnggotaArisann;
import com.adit.arisan.activity.Arisann;
import com.adit.arisan.model.Security;
import com.adit.arisan.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginArisan extends AppCompatActivity {
    EditText tUsername, tPassword;
    Button btnLogin;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tUsername = (EditText) findViewById(R.id.edt_username);
        tPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd = null;
                try {
                    pwd = Security.encrypt(tPassword.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                logIn(tUsername.getText().toString(), pwd);
            }
        });
    }

    private void logIn(final String username, final String password) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(username).exists()) {
                    if (!username.isEmpty()) {
                        User login = dataSnapshot.child(username).getValue(User.class);
                        if (login.getPassword().equals(password)) {
                            Toast.makeText(LoginArisan.this, "Login Success", Toast.LENGTH_LONG).show();
                            Intent intphto = new Intent(getApplicationContext(), Arisann.class);
                            startActivity(intphto);
                        } else {
                            Toast.makeText(LoginArisan.this, "Password Incorrect", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(LoginArisan.this, "User is not register", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(LoginArisan.this, "User is not register", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void clickSignUp(View view) {
        Intent intent = new Intent(this, RegisterArisan.class);
        startActivity(intent);
    }
}












