package com.example.schoolapp.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.schoolapp.Fragments.AbsencesFragment;

public class AttendaceAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    Bundle bundle;

    public AttendaceAdapter(FragmentManager fm, Context context, Bundle bundle) {
        super(fm);
        mContext = context;
        this.bundle = bundle;
    }


    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Fragment fragment = new AbsencesFragment();
            fragment.setArguments(this.bundle);
            return fragment;
        } else {
            Fragment fragment = new AbsencesFragment();
            fragment.setArguments(this.bundle);
            return fragment;
        }
    }


    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Absences";
            case 1:
                return "Leaves";
            default:
                return null;
        }
    }


}