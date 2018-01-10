package com.example.meritonf.projekti_2_3.activities.activities.activities.main_activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.example.meritonf.projekti_2_3.R;
import com.example.meritonf.projekti_2_3.activities.activities.activities.adapters.ViewPagerAdapter;

/**
 * Created by meritonf on 1/7/2018.
 */

public class PagerActivity extends Activity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;

    private String[] images = {
            "https://picsum.photos/200/300/?image=764",
            "https://picsum.photos/200/300/?image=130",
            "https://picsum.photos/200/300/?image=172",
            "https://picsum.photos/200/300/?image=495",
            "https://picsum.photos/200/300/?image=678",
            "https://picsum.photos/200/300/?image=803",
            "https://picsum.photos/200/300/?image=80",
            "https://picsum.photos/200/300/?image=775",
            "https://picsum.photos/200/300/?image=88",
            "https://picsum.photos/200/300/?image=96"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_cell);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(PagerActivity.this,images);
        viewPager.setAdapter(adapter);
    }
}
