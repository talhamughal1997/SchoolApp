package com.example.schoolapp.Fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolapp.Adapters.GradesAdapter;
import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.Model.MarksModel;
import com.example.schoolapp.R;
import com.example.schoolapp.Retrofit.RestApi;
import com.example.schoolapp.Retrofit.RetrofitClientInstance;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class GradesFragment extends Fragment {

    View rootView;
    Dialog progressDialog;
    TextView mTextView_username, mTextView_percAvg;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_grades, container, false);
        viewInit();
        mTextView_username.setText(Utils.STUDENT_DATA.getName());
        Utils.changeTitle(getActivity(), "Grades");
        getData();
        return rootView;
    }

    private void viewInit() {
        progressDialog = Utils.getProgressDialog(getActivity());
        mTextView_username = rootView.findViewById(R.id.txt_username);
        mTextView_percAvg = rootView.findViewById(R.id.txt_percAvg);
    }

    private void setRecyclerView(ArrayList<MarksModel.Data.Marks> arrayList) {
        recyclerView = rootView.findViewById(R.id.rec_grades);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new GradesAdapter(arrayList, getActivity()));
    }

    private void getData() {
        progressDialog.show();
        final RestApi apiService = RetrofitClientInstance.getRetrofitInstance().create(RestApi.class);
        Call<MarksModel> call = apiService.GetMarks(null, Utils.DEVICE_ID);

        call.enqueue(new Callback<MarksModel>() {
            @Override
            public void onResponse(Call<MarksModel> call, Response<MarksModel> response) {
                setRecyclerView(response.body().getData().getMarksList());
                mTextView_percAvg.setText(getPerAvg(response.body().getData().getMarksList())+"%");
                progressDialog.hide();
            }

            @Override
            public void onFailure(Call<MarksModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.hide();
            }
        });
    }

    private String getPerAvg(ArrayList<MarksModel.Data.Marks> arrayList) {
        double a = 0,b = 0;
        for (MarksModel.Data.Marks model : arrayList) {
            if (model.getMark() == null){
                continue;
            }
            a += Double.parseDouble(model.getMark());
        }
        b = a / arrayList.size();
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(b);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.changeTitle(getActivity(), true);
    }

}
