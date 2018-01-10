package com.example.meritonf.projekti_2_3.activities.activities.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meritonf.projekti_2_3.R;
import com.example.meritonf.projekti_2_3.activities.activities.activities.main_activities.SingleMonthActivity;
import com.example.meritonf.projekti_2_3.activities.activities.activities.models.Month;

import java.util.ArrayList;

/**
 * Created by meritonf on 1/8/2018.
 */

public class MonthsAdapter  extends BaseAdapter{

    private LayoutInflater mInflater;
    private ArrayList<Month> months = new ArrayList<>();
    private Context context;

    public MonthsAdapter(Context context, ArrayList<Month> months){
        this.context = context;
        this.months = months;
        setupInflater();
    }

    private void setupInflater(){
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    class Holder{
        TextView monthName, monthDesc;
        ImageView monthImage;
    }

    @Override
    public int getCount() {
        return months.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        Holder holder;
        final Month month;
        if(view == null){
            view = mInflater.inflate(R.layout.months_cell, viewGroup, false);
            holder = new Holder();
            holder.monthDesc = (TextView) view.findViewById(R.id.monthDesc);
            holder.monthName = (TextView) view.findViewById(R.id.monthName);
            holder.monthImage= (ImageView) view.findViewById(R.id.monthImage);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        month = months.get(position);
        holder.monthDesc.setText(month.getDescription());
        holder.monthName.setText(month.getTitulli());
        //holder.monthImage.setImageResource();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, SingleMonthActivity.class);
                intent.putExtra("id", month.getId());
                intent.putExtra("title", month.getTitulli());
                intent.putExtra("description", month.getDescription());
                intent.putExtra("img", month.getPhotoURL());
                context.startActivity(intent);
//                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
