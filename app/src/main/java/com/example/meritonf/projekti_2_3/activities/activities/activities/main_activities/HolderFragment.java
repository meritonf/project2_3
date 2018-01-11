package com.example.meritonf.projekti_2_3.activities.activities.activities.main_activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.meritonf.projekti_2_3.R;
import com.example.meritonf.projekti_2_3.activities.activities.activities.API.MonthTask;
import com.example.meritonf.projekti_2_3.activities.activities.activities.API.MonthsCallback;
import com.example.meritonf.projekti_2_3.activities.activities.activities.adapters.MonthsAdapter;
import com.example.meritonf.projekti_2_3.activities.activities.activities.models.Month;

import java.util.ArrayList;

/**
 * Created by meritonf on 1/10/2018.
 */

public class HolderFragment extends Fragment {


    private MonthsCallback monthsCallback;
    private MonthTask monthTask;
    private ArrayList<Month> months = new ArrayList<>();
    private ListView listView;
    private MonthsAdapter adapter;
    private ProgressBar progressBar;
    private int counter = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("holderfragment : onCreate");
        Bundle bundle = getArguments();
        if(bundle != null){
            counter= bundle.getInt("counter", 0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_holder_static,container,false);
        System.out.println("onCreateView");
        progressBar = view.findViewById(R.id.progressBar);
        listView = view.findViewById(R.id.listView);
        adapter = new MonthsAdapter(getContext(), months);
        listView.setAdapter(adapter);
        initializeServiceObjects();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("holderfragment : onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
        monthTask = new MonthTask(monthsCallback, getContext());
    }

    private void requestMonthsData(){
        monthTask.execute();
    }
}
