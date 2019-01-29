package com.example.sebas.ich_hasse_android_bewetet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class FacultyActivity extends AppCompatActivity {

    private static ProgressBar bar;
    private static TextView fOUT;
    private TextView fIN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        bar = findViewById(R.id.progressBar);
        fIN = findViewById(R.id.fInput);
        fOUT = findViewById(R.id.foutput);
    }

    public static ProgressBar getStaticProgrssBar(){
        return bar;
    }

    public static void setFResult(int result){
        fOUT.setText("REsult: "+result);
    }

    public void buttonPressed(View view){
        bar.setProgress(0);
        int temp = 0;
        try {
            temp = Integer.parseInt(fIN.getText().toString());
        } catch (NumberFormatException e) {
            temp = 1;
        }
        new FacultyCalculation().execute(temp);
    }
}

class FacultyCalculation extends AsyncTask<Integer,Integer,Double> {

    @Override
    protected Double doInBackground(Integer... integers) {
        int input = integers[0];
        int sum = 1;
        while(input>1){
            sum *= input--;
            double percent = (1-(input/integers[0]));
            int up = (int) percent*100;
            publishProgress(up);
        }
        return (double)sum;
    }

    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate();
        Log.i("facultymy",""+values[0]);
        FacultyActivity.getStaticProgrssBar().setProgress(values[0],true);
    }

    @Override
    protected void onPostExecute(Double result){
        FacultyActivity.setFResult((int) (double) result);
    }


}

