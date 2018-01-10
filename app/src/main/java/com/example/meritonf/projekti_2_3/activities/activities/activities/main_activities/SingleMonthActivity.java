package com.example.meritonf.projekti_2_3.activities.activities.activities.main_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meritonf.projekti_2_3.R;
import com.squareup.picasso.Picasso;

import java.net.URLDecoder;
import java.net.URLEncoder;

import okio.Utf8;

import static android.provider.CalendarContract.CalendarCache.URI;

/**
 * Created by meritonf on 1/8/2018.
 */

public class SingleMonthActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlemonth);

        Intent intent = getIntent();
        String Id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("description");
        String img = intent.getStringExtra("img");

        TextView idTxtView = (TextView) findViewById(R.id.id);
        TextView titleTxtView = (TextView) findViewById(R.id.title);
        TextView descTxtView = (TextView) findViewById(R.id.description);
        ImageView imgView = (ImageView) findViewById(R.id.img);

        idTxtView.setText(Id);
        titleTxtView.setText(title);
        descTxtView.setText(desc);

        System.out.println("URL "+ img);

        Picasso.with(this)
                .load(img)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imgView);
    }
}
