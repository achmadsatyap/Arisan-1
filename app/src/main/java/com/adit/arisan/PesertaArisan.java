package com.adit.arisan;

import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.adit.arisan.fragment.AnggotaArisan;
import com.adit.arisan.fragment.Arisan;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;


public class PesertaArisan extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
Arisan.OnFragmentInteractionListener{
    private Arisan arisan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        arisan = new Arisan();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadFragment(new AnggotaArisan());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.peserta:
                fragment = new AnggotaArisan();
                break;

            case R.id.arisan:
                 fragment = new Arisan();
                break;

        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
