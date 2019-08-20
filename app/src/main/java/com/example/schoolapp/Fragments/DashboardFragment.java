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

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements View.OnClickListener {
    View rootView;
    LinearLayout ln_Homework, ln_Attendance, ln_Grades, ln_Announcements, ln_Subjects, ln_Curricular, ln_TimeTable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        viewInits();
        viewListners();

        return rootView;
    }

    private void viewInits() {
        ln_Homework = rootView.findViewById(R.id.ln_homework);
        ln_Attendance = rootView.findViewById(R.id.ln_attendance);
        ln_Grades = rootView.findViewById(R.id.ln_grades);
        ln_Announcements = rootView.findViewById(R.id.ln_announcements);
        ln_Subjects = rootView.findViewById(R.id.ln_subjects);
        ln_TimeTable = rootView.findViewById(R.id.ln_timetable);
    }

    private void viewListners() {
        ln_Homework.setOnClickListener(this);
        ln_Attendance.setOnClickListener(this);
        ln_Grades.setOnClickListener(this);
        ln_TimeTable.setOnClickListener(this);
        ln_Announcements.setOnClickListener(this);
        ln_Subjects.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ln_homework: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new HomeWorkFragment());
                break;
            }
            case R.id.ln_attendance: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new AttendanceFragment());
                break;
            }
            case R.id.ln_grades: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new GradesFragment());
                break;
            }
            case R.id.ln_announcements: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new AnnouncementFragment());
                break;
            }
            case R.id.ln_subjects: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new SubjectsFragment());
                break;
            }
            case R.id.ln_timetable: {
                Utils.changeFragment((AppCompatActivity) getActivity(), new TimeTableFragment());
                break;
            }
        }
    }
}
