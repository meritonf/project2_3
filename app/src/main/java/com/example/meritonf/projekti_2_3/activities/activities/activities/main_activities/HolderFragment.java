package com.example.meritonf.projekti_2_3.activities.activities.activities.main_activities;

import android.os.Bundle;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.months_cell,container,false);
        System.out.println("onCreateView");
        progressBar = view.findViewById(R.id.progressBar);
        listView = view.findViewById(R.id.listView);
        adapter = new MonthsAdapter(getContext(), months);
        listView.setAdapter(adapter);

        return view;
    }
}
