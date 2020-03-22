package com.example.mycloudtv.machine.adapter;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentTabAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> viewcontainer;

    public FragmentTabAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Fragment> viewcontainer) {
        super(fm, behavior);
        this.viewcontainer = viewcontainer;
    }

    @Override
    public Fragment getItem(int arg0) {
        return viewcontainer.get(arg0);
    }

    @Override
    public int getCount() {
        if (viewcontainer == null) {
            return 0;
        } else {
            return viewcontainer.size();
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}