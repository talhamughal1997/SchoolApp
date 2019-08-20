package com.example.schoolapp.Activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
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

public class SplashActivity extends AppCompatActivity implements NetworkStateChangeReceiver.NetworkListener {

    private int TIMEOUT = 1000;
    Dialog progressDialog;
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Utils.DEVICE_ID = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        //id = 7a7d9465dad8e9fe
    }

    private void getDataFromSharedPref() {
        SharedPreferences prefs = getSharedPreferences(Utils.LOGIN_PREF, MODE_PRIVATE);
        String restoredText = prefs.getString("username", null);
        if (restoredText != null) {
            String username = prefs.getString("username", null);
            String password = prefs.getString("password", null);
            PostLogin(username, password);
        } else {
            Utils.changeActivity(SplashActivity.this, LoginActivity.class);
        }
    }

    private void PostLogin(String username, String password) {
        RestApi apiService = RetrofitClientInstance.getRetrofitInstance().create(RestApi.class);
        Call<StudentModel> call = apiService.PostLogin(username, password, Utils.DEVICE_ID);

        call.enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getResult().getStatus() != null) {
                        if (!response.body().getResult().getStatus().toLowerCase().equals("error")) {
                            Utils.STUDENT_DATA = response.body().getData().getStudent_data();
                            Utils.changeActivity(SplashActivity.this, DashboardActivity.class);

                        } else {
                            Utils.changeActivity(SplashActivity.this, LoginActivity.class);
                        }
                    } else {
                        Utils.changeActivity(SplashActivity.this, LoginActivity.class);
                    }

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        finishAffinity();
                    }

                } else {
                    Toast.makeText(SplashActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {

            }
        });
    }

    private void setSplash() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getDataFromSharedPref();
            }
        }, TIMEOUT);
    }

    @Override
    public void onNetworkAvailable() {
        if (progressDialog!=null) progressDialog.hide();
        setSplash();
    }

    @Override
    public void onNetworkUnavailable() {
        progressDialog = Utils.getProgressDialog(SplashActivity.this);
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
