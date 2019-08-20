package com.example.schoolapp.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeTableFragment extends Fragment {

    View rootView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_time_table, container, false);
        Utils.changeTitle(getActivity(),"Time Table");

        viewPager = rootView.findViewById(R.id.timetable_viewpager);
        tabLayout = rootView.findViewById(R.id.timetable_tablayout);

        viewPager.setAdapter(new DaysAdapter(getActivity().getSupportFragmentManager(), getActivity()));
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }


    private class DaysAdapter extends FragmentStatePagerAdapter {

        private Context mContext;

        public DaysAdapter(FragmentManager fm, Context context) {
            super(fm);
            mContext = context;
        }

        // This determines the fragment for each tab
        @Override
        public Fragment getItem(int position) {
            return new DaysFragment();
        }


        // This determines the number of tabs
        @Override
        public int getCount() {
            return 7;
        }

        // This determines the title for each tab
        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            switch (position) {
                case 0:
                    return "Monday";
                case 1:
                    return "Tuesday";
                case 2:
                    return "Wednesday";
                case 3:
                    return "Thursday";
                case 4:
                    return "Friday";
                case 5:
                    return "Saturday";
                case 6:
                    return "Sunday";
                default:
                    return null;
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.changeTitle(getActivity(),true);
    }
}
