package com.example.freshupnew.Activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.freshupnew.R;

public class verification extends AppCompatActivity {

    EditText one,two,three,four;
    Button verify,dialogbutton;
    Dialog dialog;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        verify=findViewById(R.id.btnverify);
        one=findViewById(R.id.otp1);
        two=findViewById(R.id.otp2);
        three=findViewById(R.id.otp3);
        four=findViewById(R.id.otp4);






        one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()==1)
                {
                    two.requestFocus();
                    one.setElevation(1);
                }
                else if(s.length()==0)
                {

                }
            }
        });

        two.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1){
                    three.requestFocus();
                    two.setElevation(1);
                }
                else if(s.length()==0){

                    one.requestFocus();
                }
            }
        });

        three.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()==1){
                   four.requestFocus();
                    three.setElevation(1);
                }
                else if(s.length()==0){
                    two.requestFocus();
                }
            }
        });

        four.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()==1){
                    four.setElevation(1);
                }
               else if(s.length()==0){
                 three.requestFocus();
                }
            }
        });


        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog=new Dialog(context);
                dialog.setContentView(R.layout.dialog_verify);

                dialogbutton=(Button)dialog.findViewById(R.id.btndone);

                dialogbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(verification.this, Homepage.class));
                    }
                });


                  dialog.show();
            }
        });
    }
}
