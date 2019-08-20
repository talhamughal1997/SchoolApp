package com.example.schoolapp.Fragments;


import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.schoolapp.Adapters.RecyclerSectionItemDecoration;
import com.example.schoolapp.Adapters.StickyAdapter;
import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.Model.AssignmentModel;
import com.example.schoolapp.R;
import com.example.schoolapp.Retrofit.RestApi;
import com.example.schoolapp.Retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeWorkFragment extends Fragment {
    Dialog progressDialog;
    CalendarView calendarView;

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home_work, container, false);
        calendarView = rootView.findViewById(R.id.homework_calendar);
        Utils.changeTitle(getActivity(), "Home Work");
        progressDialog = Utils.getProgressDialog(getActivity());

        getAssignments(null);
        setCalendarView();

        return rootView;
    }

    private void setCalendarView() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                getAssignments(year + "/" + ++month + "/" + dayOfMonth);
            }
        });
    }

    private void setRecyclerView(ArrayList<AssignmentModel.Assignments> arrayList) {
        if (arrayList.size()!=0) {
            RecyclerView mRecyclerView;
            mRecyclerView = rootView.findViewById(R.id.homework_recycler);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerView.Adapter adapter;
            adapter = new StickyAdapter(getActivity(), arrayList);
            mRecyclerView.setAdapter(adapter);

            RecyclerSectionItemDecoration sectionItemDecoration =
                    new RecyclerSectionItemDecoration(getResources().getDimensionPixelSize(R.dimen.header),
                            true,
                            getSectionCallback(arrayList));
            mRecyclerView.addItemDecoration(sectionItemDecoration);
        }
        else
        {
            RecyclerView mRecyclerView;
            mRecyclerView = rootView.findViewById(R.id.homework_recycler);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerView.Adapter adapter;
            adapter = new StickyAdapter(getActivity(), new ArrayList<AssignmentModel.Assignments>());
            mRecyclerView.setAdapter(adapter);
        }
    }

    private RecyclerSectionItemDecoration.SectionCallback getSectionCallback(final List<AssignmentModel.Assignments> arraylist) {
        return new RecyclerSectionItemDecoration.SectionCallback() {
            @Override
            public boolean isSection(int position) {
                return position == 0
                        || arraylist.get(position)
                        .getSubject() != arraylist.get(position - 1)
                        .getSubject();
            }

            @Override
            public CharSequence getSectionHeader(int position) {
                return arraylist.get(position).getSubject();
            }
        };
    }

    private void getAssignments(String date) {
        progressDialog.show();
        RestApi apiService = RetrofitClientInstance.getRetrofitInstance().create(RestApi.class);
        Call<AssignmentModel> call = apiService.GetAssignment(date, Utils.DEVICE_ID);

        call.enqueue(new Callback<AssignmentModel>() {
            @Override
            public void onResponse(Call<AssignmentModel> call, Response<AssignmentModel> response) {
                if (response.isSuccessful()) {
                    setRecyclerView(response.body().getData().getAssignmentArrayList());
                }
                progressDialog.hide();
            }

            @Override
            public void onFailure(Call<AssignmentModel> call, Throwable t) {
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
