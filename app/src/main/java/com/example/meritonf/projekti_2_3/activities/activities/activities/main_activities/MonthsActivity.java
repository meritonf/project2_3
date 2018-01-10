package com.example.meritonf.projekti_2_3.activities.activities.activities.main_activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.meritonf.projekti_2_3.R;
import com.example.meritonf.projekti_2_3.activities.activities.activities.API.MonthTask;
import com.example.meritonf.projekti_2_3.activities.activities.activities.API.MonthsCallback;
import com.example.meritonf.projekti_2_3.activities.activities.activities.adapters.MonthsAdapter;
import com.example.meritonf.projekti_2_3.activities.activities.activities.models.Month;

import java.util.ArrayList;

/**
 * Created by meritonf on 1/8/2018.
 */

public class MonthsActivity extends Activity {
    private MonthsCallback monthsCallback;
    private MonthTask monthTask;
    private ArrayList<Month> months = new ArrayList<>();
    private ListView listView;
    private MonthsAdapter adapter;
    private ProgressBar progressBar;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
        progressBar = findViewById(R.id.progressBar);
        listView = findViewById(R.id.listView);
        adapter = new MonthsAdapter(getApplicationContext(), months);
        listView.setAdapter(adapter);
        initializeServiceObjects();
    }

    private void initializeServiceObjects(){
        monthsCallback = new MonthsCallback() {
            @Override
            public void onMonthsResponse(ArrayList<Month> inMonths, boolean success) {
                if(success){
                    months.addAll(inMonths);
                    adapter.notifyDataSetChanged();
                }
                progressBar.setVisibility(View.GONE);
            }
        };
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                requestMonthsData();
            }
        }, 2000);
        monthTask = new MonthTask(monthsCallback, getBaseContext());
    }

    private void requestMonthsData(){
        monthTask.execute();
    }
}
