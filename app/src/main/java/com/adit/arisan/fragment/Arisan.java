package com.adit.arisan.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adit.arisan.HasilArisan;
import com.adit.arisan.R;
import com.adit.arisan.TambahGrup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Arisan.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Arisan extends Fragment{

    private OnFragmentInteractionListener mListener;

    public Arisan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_arisan, container, false);
        FloatingActionButton tambahButton= view.findViewById(R.id.fab);
        tambahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent sae = new Intent(getActivity(), TambahGrup.class);
                    startActivity(sae);

                }
        });
//       TextView textView =  view.findViewById(R.id.contoh);
//       textView.setOnClickListener(new View.OnClickListener() {
//
//           @Override
//           public void onClick(View view) {
//               Intent sae = new Intent(getActivity(), HasilArisan.class);
//               startActivity(sae);
//           }
//       });
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.fab:
//                Intent intent = new Intent(getActivity(), TambahGrup.class);
//                startActivity(intent);
//                break;
//            case R.id.contoh:
//                Intent intent1 = new Intent(getActivity(), HasilArisan.class);
//                startActivity(intent1);
//                break;
//        }
//
//    }

/**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name

    }
}
