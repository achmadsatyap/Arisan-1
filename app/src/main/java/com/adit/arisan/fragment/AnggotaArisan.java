package com.adit.arisan.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnggotaArisan extends Fragment {

//    DatabaseReference databaseReference;
//    ListView listView;
//    ArrayList<Peserta> arrayList = new ArrayList<Peserta>();
//    Module module;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anggota_arisan, container, false);
//        databaseReference = FirebaseDatabase.getInstance().getReference("Peserta");
//        module = ((Module)getApplicationContext());
//        listView = (ListView) view.findViewById(R.id.listviewtxt);
//         final ArrayAdapter<Peserta> arrayAdapter = new ArrayAdapter<Peserta>(view.getContext(), android.R.layout.simple_list_item_1,arrayList);
//        listView.setAdapter(arrayAdapter);
//        databaseReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                Peserta peserta =dataSnapshot.getValue(Peserta.class);
//                arrayList.add(peserta);
//                arrayAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TambahPeserta.class));

            }
        });
        return view;

    }

//    private Object getApplicationContext() {
//        return module;
//    }
}
