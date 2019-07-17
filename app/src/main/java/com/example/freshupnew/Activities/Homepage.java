package com.example.freshupnew.Activities;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.freshupnew.Fragments.Frag_Home_Main;
import com.example.freshupnew.Fragments.Frag_Profile;
import com.example.freshupnew.Fragments.Frag_Settings;
import com.example.freshupnew.R;

public class Homepage extends AppCompatActivity {

    Context context = this;
    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        bottomNavigationView = findViewById(R.id.navigation);

        getfragment(new Frag_Home_Main());

//        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
//
//
//                switch (menuItem.getItemId()) {
//
//                    case R.id.home:
//                        getfragment(new Frag_Home_Main());
//                        break;
//
//                    case R.id.promo:
//
//                        break;
//
//                    case R.id.profile:
//                        getfragment(new Frag_Profile());
//                        break;
//
//                    case R.id.settings:
//                        getfragment(new Frag_Settings());
//                        break;
//                }
//            }
//        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.home:
                        getfragment(new Frag_Home_Main());
                        break;

                    case R.id.promo:

                        final Dialog dialog = new Dialog(context);
                        dialog.setContentView(R.layout.promo_dialog);
                        Button dialogbutton = (Button) dialog.findViewById(R.id.btnpromo);
                        final EditText promocode=(EditText)dialog.findViewById(R.id.promoet);

                        dialogbutton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String promo_code=promocode.getText().toString();

                                dialog.dismiss();
                            }
                        });

                        dialog.show();

                        break;

                    case R.id.profile:
                        getfragment(new Frag_Profile());
                        break;

                    case R.id.settings:
                        getfragment(new Frag_Settings());
                        break;
                }

                return true;
            }
        });


    }

    private void getfragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();

    }

}
