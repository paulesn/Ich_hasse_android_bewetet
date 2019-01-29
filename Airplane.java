package com.example.sebas.ich_hasse_android_bewetet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

public class Airplane extends BroadcastReceiver {

    public Airplane(){
    }

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("AirplaneMode", "Service state changed");
            Toast.makeText(context,"Airplane mode changed",Toast.LENGTH_LONG).show();
        }




}
