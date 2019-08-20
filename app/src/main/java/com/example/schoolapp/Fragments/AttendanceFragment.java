package com.example.schoolapp.Fragments;


import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.schoolapp.Adapters.AttendaceAdapter;
import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.Model.AttendanceModel;
import com.example.schoolapp.R;
import com.example.schoolapp.Retrofit.RestApi;
import com.example.schoolapp.Retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceFragment extends Fragment {

    View rootView;
    ViewPager viewPager;
    TabLayout tabLayout;
    PieChartView pieChartView1, pieChartView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_attendance, container, false);
        Utils.changeTitle(getActivity(), "Attendance");

        viewPager = rootView.findViewById(R.id.att_viewpager);
        tabLayout = rootView.findViewById(R.id.att_tablayout);

        GetAttendance();

        return rootView;
    }

    private void setPieChart(int a, int b) {
        pieChartView1 = rootView.findViewById(R.id.att_piechart1);
        pieChartView2 = rootView.findViewById(R.id.att_piechart2);

        List<SliceValue> pieData = new ArrayList<>();

        pieData.add(new SliceValue(a, getActivity().getResources().getColor(R.color.colorPrimaryDark)));
        pieData.add(new SliceValue(b, Color.parseColor("#F5F5F5")));
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasCenterCircle(true).setCenterText1("" + a);
        pieChartView1.setPieChartData(pieChartData);
        pieData = new ArrayList<>();
        pieData.add(new SliceValue(b, getActivity().getResources().getColor(R.color.colorPrimaryDark)));
        pieData.add(new SliceValue(a, Color.parseColor("#F5F5F5")));
        pieChartData = new PieChartData(pieData);
        pieChartData.setHasCenterCircle(true).setCenterText1("" + b);
        pieChartView2.setPieChartData(pieChartData);
    }

    private void GetAttendance() {

        final Dialog progressDialog = Utils.getProgressDialog(getActivity());
        progressDialog.show();
        RestApi apiService = RetrofitClientInstance.getRetrofitInstance().create(RestApi.class);
        Call<AttendanceModel> call = apiService.GetAttendance("06-2019", Utils.DEVICE_ID);

        call.enqueue(new Callback<AttendanceModel>() {
            @Override
            public void onResponse(Call<AttendanceModel> call, Response<AttendanceModel> response) {
                if (response.isSuccessful()) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(AttendanceModel.class.getSimpleName(), response.body());
                    viewPager.setAdapter(new AttendaceAdapter(getActivity().getSupportFragmentManager(), getActivity(), bundle));
                    tabLayout.setupWithViewPager(viewPager);
                    setPieChart(response.body().data.total_absent, response.body().data.total_present);
                    progressDialog.hide();
                }
            }

            @Override
            public void onFailure(Call<AttendanceModel> call, Throwable t) {
                progressDialog.hide();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.changeTitle(getActivity(), true);
    }


}
