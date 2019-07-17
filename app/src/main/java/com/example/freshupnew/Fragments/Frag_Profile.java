package com.example.freshupnew.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.freshupnew.R;
import com.example.freshupnew.Activities.Login;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Profile extends Fragment {
    Button logout;


    public Frag_Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


                View view= inflater.inflate(R.layout.fragment_user_profile, container, false);
        logout=view.findViewById(R.id.btnlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);


            }
        });
        return view;
    }
//    private void openfragment(Fragment fragment){
//
//        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
//        FragmentTransaction transaction=fragmentManager.beginTransaction();
//        transaction.replace(R.id.fraglayout,fragment);
//        transaction.commit();
//
//    }

}
