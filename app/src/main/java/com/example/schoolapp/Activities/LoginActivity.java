package com.example.schoolapp.Activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schoolapp.Controllers.NetworkStateChangeReceiver;
import com.example.schoolapp.Controllers.Utils;
import com.example.schoolapp.Model.StudentModel;
import com.example.schoolapp.R;
import com.example.schoolapp.Retrofit.RestApi;
import com.example.schoolapp.Retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements NetworkStateChangeReceiver.NetworkListener {

    EditText editText1, editText2;
    Button btn_login;
    Dialog progressDialog;
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = findViewById(R.id.user);
        editText2 = findViewById(R.id.password);
        btn_login = findViewById(R.id.btnlogin);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostLogin(editText1.getText().toString(), editText2.getText().toString());
            }
        });

    }

    private void PostLogin(String username, String password) {

        final Dialog progressDialog = Utils.getProgressDialog(this);
        progressDialog.show();
        RestApi apiService = RetrofitClientInstance.getRetrofitInstance().create(RestApi.class);
        Call<StudentModel> call = apiService.PostLogin(username, password, Utils.DEVICE_ID);

        call.enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                if (response.isSuccessful()) {
                    if (!response.body().getResult().getStatus().toLowerCase().equals("error")) {
                        setSharedPreferences(editText1.getText().toString(), editText2.getText().toString());
                        Utils.STUDENT_DATA = response.body().getData().getStudent_data();
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            finishAffinity();
                        }
                    }
                    progressDialog.hide();
                    Toast.makeText(LoginActivity.this, response.body().getResult().getResponse(), Toast.LENGTH_SHORT).show();
                }
                else {
                    progressDialog.hide();
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {
                progressDialog.hide();
            }
        });
    }

    private void setSharedPreferences(String username, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(Utils.LOGIN_PREF, MODE_PRIVATE).edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    @Override
    public void onNetworkAvailable() {
        if (progressDialog!=null) progressDialog.hide();
    }

    @Override
    public void onNetworkUnavailable() {
        progressDialog = Utils.getProgressDialog(LoginActivity.this);
        progressDialog.setTitle("No Internet!");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        receiver = new NetworkStateChangeReceiver(this);
        registerReceiver(receiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

}



