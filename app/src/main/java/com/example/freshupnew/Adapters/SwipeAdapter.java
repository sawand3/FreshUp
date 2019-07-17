package com.example.freshupnew.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.freshupnew.Fragments.frag1;
import com.example.freshupnew.Fragments.frag2;
import com.example.freshupnew.Fragments.frag3;

public class SwipeAdapter extends FragmentPagerAdapter {


    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;


        switch (position){
            case 0:
                fragment=new frag1();
                break;
            case 1:
                fragment =new frag2();
                break;
            case 2:
                fragment=new frag3();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}



