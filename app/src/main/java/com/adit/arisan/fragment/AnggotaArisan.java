package com.adit.arisan.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adit.arisan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnggotaArisan extends Fragment {


    public AnggotaArisan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anggota_arisan, container, false);
    }

}
