package com.adit.arisan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.adit.arisan.activity.AnggotaArisann;
import com.adit.arisan.activity.Arisann;


public class PesertaArisan extends AppCompatActivity {
//    private Arisan arisan;
    public Menu menu;

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
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        arisan = new Arisan();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        loadFragment(new AnggotaArisann());
//        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
//        // beri listener pada saat item/menu bottomnavigation terpilih
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
//    }
//
//    private boolean loadFragment(Fragment fragment) {
//        if (fragment != null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, fragment)
//                    .addToBackStack(null)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
////        Fragment fragment = null;
//        switch (menuItem.getItemId()) {
//            case R.id.peserta:
//                Intent in = new Intent(getApplication(), AnggotaArisann.class);
//                startActivity(in);
//                break;
//
//            case R.id.arisan:
//               Intent inte = new Intent(getApplication(),Arisann.class);
//               startActivity(inte);
//                break;
//
//        }
//        return super.onOptionsItemSelected(menuItem);
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
    }




}
