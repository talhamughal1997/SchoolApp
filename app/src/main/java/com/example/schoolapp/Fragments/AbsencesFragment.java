package com.example.schoolapp.Fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.Model.AbsencesModel;
import com.example.schoolapp.Model.AttendanceModel;
import com.example.schoolapp.R;
import com.example.schoolapp.Retrofit.RestApi;
import com.example.schoolapp.Retrofit.RetrofitClientInstance;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AbsencesFragment extends Fragment {
    RecyclerView recyclerView;
    AttendanceAdapter adapter;
    View rootView;
    AttendanceModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_absences, container, false);

        model = (AttendanceModel) getArguments().getSerializable(AttendanceModel.class.getSimpleName());
        setAbsences();
        return rootView;
    }

    private void setRecyclerView(ArrayList<AbsencesModel> arrayList) {
        if (adapter == null) {
            recyclerView = rootView.findViewById(R.id.absc_recylcer);
            adapter = new AttendanceAdapter(arrayList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        } else {
            setRecyclerViewAdapter(arrayList);
        }

    }

    private void setRecyclerViewAdapter(ArrayList<AbsencesModel> arrayList) {
        if (adapter != null) {
            for (int a = 0; a < arrayList.size(); a++) {
                adapter.arrayList.add(arrayList.get(a));
                adapter.notifyDataSetChanged();
            }
        }
    }




    private void setAbsences() {
        for (int a = 0; a < model.data.getAttendances().size(); a++) {
            setRecyclerView(getAbsences(model, a));
        }
    }

    public ArrayList<AbsencesModel> getAbsences(AttendanceModel attendanceModel, int index) {
        ArrayList<AbsencesModel> arrayList;
        arrayList = new ArrayList<>();
        String mdate, mday;

        if (attendanceModel.data.getAttendances().get(index).a1 != null) {
            if (attendanceModel.data.getAttendances().get(index).a1.toLowerCase().equals("a")) {
                mdate = getDate("1");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }

        if (attendanceModel.data.getAttendances().get(index).a2 != null) {
            if (attendanceModel.data.getAttendances().get(index).a2.toLowerCase().equals("a")) {
                mdate = getDate("2");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a3 != null) {
            if (attendanceModel.data.getAttendances().get(index).a3.toLowerCase().equals("a")) {
                mdate = getDate("3");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a4 != null) {
            if (attendanceModel.data.getAttendances().get(index).a4.toLowerCase().equals("a")) {
                mdate = getDate("4");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a5 != null) {
            if (attendanceModel.data.getAttendances().get(index).a5.toLowerCase().equals("a")) {
                mdate = getDate("5");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a6 != null) {
            if (attendanceModel.data.getAttendances().get(index).a6.toLowerCase().equals("a")) {
                mdate = getDate("6");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a7 != null) {
            if (attendanceModel.data.getAttendances().get(index).a7.toLowerCase().equals("a")) {
                mdate = getDate("7");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a8 != null) {
            if (attendanceModel.data.getAttendances().get(index).a8.toLowerCase().equals("a")) {
                mdate = getDate("8");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a9 != null) {
            if (attendanceModel.data.getAttendances().get(index).a9.toLowerCase().equals("a")) {
                mdate = getDate("9");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a10 != null) {
            if (attendanceModel.data.getAttendances().get(index).a10.toLowerCase().equals("a")) {
                mdate = getDate("10");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a11 != null) {
            if (attendanceModel.data.getAttendances().get(index).a11.toLowerCase().equals("a")) {
                mdate = getDate("11");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a12 != null) {
            if (attendanceModel.data.getAttendances().get(index).a12.toLowerCase().equals("a")) {
                mdate = getDate("12");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a13 != null) {
            if (attendanceModel.data.getAttendances().get(index).a13.toLowerCase().equals("a")) {
                mdate = getDate("13");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a14 != null) {
            if (attendanceModel.data.getAttendances().get(index).a14.toLowerCase().equals("a")) {
                mdate = getDate("14");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a15 != null) {
            if (attendanceModel.data.getAttendances().get(index).a15.toLowerCase().equals("a")) {
                mdate = getDate("15");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a16 != null) {
            if (attendanceModel.data.getAttendances().get(index).a16.toLowerCase().equals("a")) {
                mdate = getDate("16");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a17 != null) {
            if (attendanceModel.data.getAttendances().get(index).a17.toLowerCase().equals("a")) {
                mdate = getDate("17");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a18 != null) {
            if (attendanceModel.data.getAttendances().get(index).a18.toLowerCase().equals("a")) {
                mdate = getDate("18");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a19 != null) {
            if (attendanceModel.data.getAttendances().get(index).a19.toLowerCase().equals("a")) {
                mdate = getDate("19");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a20 != null) {
            if (attendanceModel.data.getAttendances().get(index).a20.toLowerCase().equals("a")) {
                mdate = getDate("20");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a21 != null) {
            if (attendanceModel.data.getAttendances().get(index).a21.toLowerCase().equals("a")) {
                mdate = getDate("21");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a22 != null) {
            if (attendanceModel.data.getAttendances().get(index).a22.toLowerCase().equals("a")) {
                mdate = getDate("22");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a23 != null) {
            if (attendanceModel.data.getAttendances().get(index).a23.toLowerCase().equals("a")) {
                mdate = getDate("23");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a24 != null) {
            if (attendanceModel.data.getAttendances().get(index).a24.toLowerCase().equals("a")) {
                mdate = getDate("24");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a25 != null) {
            if (attendanceModel.data.getAttendances().get(index).a25.toLowerCase().equals("a")) {
                mdate = getDate("25");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a26 != null) {
            if (attendanceModel.data.getAttendances().get(index).a26.toLowerCase().equals("a")) {
                mdate = getDate("26");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a27 != null) {
            if (attendanceModel.data.getAttendances().get(index).a27.toLowerCase().equals("a")) {
                mdate = getDate("27");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a28 != null) {
            if (attendanceModel.data.getAttendances().get(index).a28.toLowerCase().equals("a")) {
                mdate = getDate("28");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a29 != null) {
            if (attendanceModel.data.getAttendances().get(index).a29.toLowerCase().equals("a")) {
                mdate = getDate("29");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a30 != null) {
            if (attendanceModel.data.getAttendances().get(index).a30.toLowerCase().equals("a")) {
                mdate = getDate("30");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        if (attendanceModel.data.getAttendances().get(index).a31 != null) {
            if (attendanceModel.data.getAttendances().get(index).a31.toLowerCase().equals("a")) {
                mdate = getDate("31");
                mday = getDay(mdate);
                AbsencesModel model = new AbsencesModel(mdate, mday);
                arrayList.add(model);
            }
        }
        return arrayList;
    }

    private String getDay(String date) {
        String input_date = date + "/07/2019";
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = null;
        try {
            dt1 = format1.parse(input_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    private String getDate(String date) {
        String input_date = date + "/07/2019";
        return input_date;
    }


    private class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {

        ArrayList<AbsencesModel> arrayList;

        public AttendanceAdapter(ArrayList<AbsencesModel> arrayList) {
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.absc_list_item, viewGroup, false);
            return new AttendanceViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AttendanceViewHolder attendanceViewHolder, int i) {
            attendanceViewHolder.txtDate.setText(arrayList.get(i).date);
            attendanceViewHolder.txtCredit.setText(arrayList.get(i).day);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        class AttendanceViewHolder extends RecyclerView.ViewHolder {
            TextView txtDate, txtCredit, txtLate;

            public AttendanceViewHolder(@NonNull View itemView) {
                super(itemView);
                txtDate = itemView.findViewById(R.id.txtDate);
                txtCredit = itemView.findViewById(R.id.txtCredit);
                txtLate = itemView.findViewById(R.id.txtLate);
            }
        }
    }

}
