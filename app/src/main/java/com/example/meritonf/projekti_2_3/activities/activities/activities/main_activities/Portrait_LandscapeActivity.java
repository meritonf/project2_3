package com.example.meritonf.projekti_2_3.activities.activities.activities.main_activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.meritonf.projekti_2_3.R;

/**
 * Created by meritonf on 1/8/2018.
 */

public class Portrait_LandscapeActivity extends Activity{

    TextView countclickView;
    Button button;

    private Integer clicks = 0 ;
    private final static String CLICK_KEY = "clicks";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait_landscape);
        countclickView = findViewById(R.id.countClicksText);
        button = findViewById(R.id.clickButton);

        if(savedInstanceState != null){
            clicks = savedInstanceState.getInt(CLICK_KEY);
            countclickView.setText(clicks.toString());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicks++;
                countclickView.setText(clicks.toString());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CLICK_KEY, clicks);
    }
}
