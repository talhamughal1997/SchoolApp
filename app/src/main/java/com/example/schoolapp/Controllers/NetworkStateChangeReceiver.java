package com.example.schoolapp.Controllers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;

public class NetworkStateChangeReceiver extends BroadcastReceiver {

    public interface NetworkListener {
        void onNetworkAvailable();

        void onNetworkUnavailable();
    }

    private NetworkListener networkListener;

    public NetworkStateChangeReceiver(NetworkListener networkListener) {
        this.networkListener = networkListener;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras().getBoolean(ConnectivityManager.EXTRA_NO_CONNECTIVITY, Boolean.FALSE)) {
            Log.d("app", "There's no network connectivity");
            networkListener.onNetworkUnavailable();
        } else {
            Log.i("app", "Network connected");
            networkListener.onNetworkAvailable();
        }
    }
}