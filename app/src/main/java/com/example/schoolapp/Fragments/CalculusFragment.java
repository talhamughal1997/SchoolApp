package com.example.schoolapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculusFragment extends Fragment {

    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_calculus, container, false);
        Utils.changeTitle(getActivity(),"Calculus");

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.changeTitle(getActivity(),true);
    }

}
