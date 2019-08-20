package com.example.schoolapp.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schoolapp.Activities.LoginActivity;
import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.Model.StatusModel;
import com.example.schoolapp.R;
import com.example.schoolapp.Retrofit.RestApi;
import com.example.schoolapp.Retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PasswordFragment extends Fragment {

    View rootView;
    EditText mEditText_old, mEditText_new;
    Button mButton_Submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_password, container, false);

        mButton_Submit = rootView.findViewById(R.id.btn_submit);
        mEditText_old = rootView.findViewById(R.id.edit_oldPswd);
        mEditText_new = rootView.findViewById(R.id.edit_newPswd);

        mButton_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPassword(mEditText_old.getText().toString(),mEditText_new.getText().toString());
            }
        });

        return rootView;
    }

    private void setPassword(String oldPswd, String newPswd) {
        RestApi apiService = RetrofitClientInstance.getRetrofitInstance().create(RestApi.class);
        Call<StatusModel> call = apiService.PasswordChange(oldPswd, newPswd, Utils.DEVICE_ID);

        call.enqueue(new Callback<StatusModel>() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onResponse(Call<StatusModel> call, Response<StatusModel> response) {

                if (response.isSuccessful())
                {
                    if (!response.body().getResult().getStatus().toLowerCase().equals("error")) {
                        Toast.makeText(getActivity(), response.body().getResult().getResponse(), Toast.LENGTH_SHORT).show();
                        Utils.changeActivityAndFinish(getActivity(), LoginActivity.class);
                    }
                }

            }

            @Override
            public void onFailure(Call<StatusModel> call, Throwable t) {

            }
        });

    }
}