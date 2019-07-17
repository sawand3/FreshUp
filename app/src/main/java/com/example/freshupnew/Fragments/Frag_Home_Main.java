package com.example.freshupnew.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.freshupnew.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Home_Main extends Fragment {

    Button btn1,btn2;

    public Frag_Home_Main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_frag_home_main, container, false);
        btn1=view.findViewById(R.id.frag1serv);
        btn2=view.findViewById(R.id.frag2prod);

        openfragment(new Fragment_Services());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn1.setBackgroundColor(getResources().getColor(R.color.white));
                btn1.setTextColor(getResources().getColor(R.color.black));

                btn2.setBackgroundColor(getResources().getColor(R.color.black));
                btn2.setTextColor(getResources().getColor(R.color.white));

                openfragment(new Fragment_Services());

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn2.setBackgroundColor(getResources().getColor(R.color.white));
                btn2.setTextColor(getResources().getColor(R.color.black));

                btn1.setBackgroundColor(getResources().getColor(R.color.black));
                btn1.setTextColor(getResources().getColor(R.color.white));

               openfragment(new Fragment_Product());
            }
        });





        return view;
    }

private void openfragment(Fragment fragment){

    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
    FragmentTransaction transaction=fragmentManager.beginTransaction();
    transaction.replace(R.id.fraglayout,fragment);
    transaction.commit();

}
}
