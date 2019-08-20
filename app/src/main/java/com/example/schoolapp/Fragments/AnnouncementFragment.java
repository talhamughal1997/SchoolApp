package com.example.schoolapp.Fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolapp.Adapters.AnnouncementAdapter;
import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.Model.AnnouncementModel;
import com.example.schoolapp.R;
import com.example.schoolapp.Retrofit.RestApi;
import com.example.schoolapp.Retrofit.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnnouncementFragment extends Fragment {

    View rootView;
    RecyclerView recyclerView;
    Dialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_announcement, container, false);
        Utils.changeTitle(getActivity(), "Announcement");
        progressDialog = Utils.getProgressDialog(getActivity());
        getAnnouncements();
        return rootView;
    }


    private void setRecyclerView(ArrayList<AnnouncementModel.Data.Notices> arrayList) {
        recyclerView = rootView.findViewById(R.id.annoucemnent_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new AnnouncementAdapter(arrayList));
    }

    private void getAnnouncements() {

        RestApi apiService = RetrofitClientInstance.getRetrofitInstance().create(RestApi.class);
        Call<AnnouncementModel> call = apiService.GetNotices(Utils.DEVICE_ID);

        call.enqueue(new Callback<AnnouncementModel>() {
            @Override
            public void onResponse(Call<AnnouncementModel> call, Response<AnnouncementModel> response) {
                setRecyclerView(response.body().getmData().getNotices());
            }

            @Override
            public void onFailure(Call<AnnouncementModel> call, Throwable t) {

            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.changeTitle(getActivity(), true);
    }

}
