package com.example.sebas.ich_hasse_android_bewetet;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(new Airplane(), new IntentFilter("android.intent.action.AIRPLANE_MODE_CHANGED"));
    }

    /**
     * faculty
     * @param view
     */
    public void btnF(View view){
        Intent intent = new Intent(this, FacultyActivity.class);
        this.startActivity(intent);
    }

    /**
     * persons
     * @param view
     */
    public void btnP(View view){

    }
}
