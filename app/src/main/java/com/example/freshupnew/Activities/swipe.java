package com.example.freshupnew.Activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.freshupnew.Adapters.SwipeAdapter;
import com.example.freshupnew.R;

public class swipe extends AppCompatActivity {

    ViewPager viewPager;
    SwipeAdapter adapter;
    private LinearLayout dotslayout;
    private int custompos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);


        dotslayout = (LinearLayout) findViewById(R.id.dotscontainer);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

//        preparedots(custompos++);
//
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//
//                if (custompos>3)
//                    custompos=0;
//                preparedots(custompos++);
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });
//
//    }
//
//    private void preparedots(int currentpos){
//        if (dotslayout.getChildCount()>0){
//            dotslayout.removeAllViews();
//
//            ImageView dots[]=new ImageView[4];
//            for (int i=0; i<4; i++){
//                dots[i]=new ImageView(this);
//                if (i==currentpos)
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.activedots));
//
//                else
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.inactivedots));
//
//                LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.setMargins(4,0,4,0);
//                dotslayout.addView(dots[i],layoutParams);
//
//            }
//        }
        }
    }

