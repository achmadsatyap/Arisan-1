package com.adit.arisan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adit.arisan.fragment.Arisan;

public class HasilArisan extends AppCompatActivity{
//    private OnFragmentInteractionListener mListener;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_arisan);
    }

    public void postKocok(View view) {
    }

    public void postHistory(View view) {
    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//
//        }
//    }
//    public interface
}
