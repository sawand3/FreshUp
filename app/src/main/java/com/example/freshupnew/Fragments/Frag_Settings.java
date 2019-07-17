package com.example.freshupnew.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.freshupnew.Activities.Payment;
import com.example.freshupnew.Activities.Product_Detail;
import com.example.freshupnew.Activities.ServicesTimeSlot;
import com.example.freshupnew.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Settings extends Fragment {

    TextView changepass, faq, terms, xyz;
    ImageView back;

    public Frag_Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_frag_settings, container, false);

        changepass=v.findViewById(R.id.changepass);
        back=v.findViewById(R.id.settings_back);
        faq=v.findViewById(R.id.faq);
        terms=v.findViewById(R.id.terms);


        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Product_Detail.class);
                startActivity(intent);
            }
        });



        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,new Frag_Change_Pass());
                fragmentTransaction.commit();
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Payment.class);
                startActivity(intent);
            }
        });



        xyz=v.findViewById(R.id.xyz);
        xyz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ServicesTimeSlot.class);
                startActivity( intent);
            }
        });

        return v;
    }



}
