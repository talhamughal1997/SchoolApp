package com.example.schoolapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.R;


public class SubjectsFragment extends Fragment implements View.OnClickListener {

    View rootView;
    LinearLayout ln_Maths, ln_Chemistry, ln_Physics, ln_Urdu, ln_English, ln_Islamiat, ln_Sindhi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_subjects, container, false);
        Utils.changeTitle(getActivity(),"Subjects");
        viewInits();
        setListners();
        return rootView;
    }

    private void viewInits() {
        ln_Maths = rootView.findViewById(R.id.maths);
        ln_Chemistry = rootView.findViewById(R.id.chemistry);
        ln_Physics = rootView.findViewById(R.id.physics);
        ln_Urdu = rootView.findViewById(R.id.urdu);
        ln_English = rootView.findViewById(R.id.english);
        ln_Islamiat = rootView.findViewById(R.id.islamiat);
        ln_Sindhi = rootView.findViewById(R.id.sindhi);
    }

    private void setListners() {
        ln_Maths.setOnClickListener(this);
        ln_Chemistry.setOnClickListener(this);
        ln_Physics.setOnClickListener(this);
        ln_Urdu.setOnClickListener(this);
        ln_English.setOnClickListener(this);
        ln_Islamiat.setOnClickListener(this);
        ln_Sindhi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.maths: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new SubjectFragment());
                break;
            }
            case R.id.chemistry: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new SubjectFragment());
                break;
            }
            case R.id.physics: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new SubjectFragment());
                break;
            }
            case R.id.urdu: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new SubjectFragment());
                break;
            }
            case R.id.english: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new SubjectFragment());
                break;
            }
            case R.id.islamiat: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new SubjectFragment());
                break;
            }
            case R.id.sindhi: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new SubjectFragment());
                break;
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.changeTitle(getActivity(),true);
    }

}
