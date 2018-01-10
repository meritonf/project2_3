package com.example.meritonf.projekti_2_3.activities.activities.activities.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meritonf.projekti_2_3.R;
import com.squareup.picasso.Picasso;

/**
 * Created by meritonf on 1/7/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    String [] images;
    public ViewPagerAdapter(Context context, String[] images){
        this.context = context;
        this.images = images;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View pagerCellView = inflater.inflate(R.layout.activity_imageview, container,false);
        System.out.println("viewPagerAdapter");

        ImageView imageView = (ImageView) pagerCellView.findViewById(R.id.imageView);

        try{
            Picasso.with(context.getApplicationContext())
                    .load(images[position])
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imageView);
        }catch(Exception ex){
            showAlertDialog("Cannot load images!");
        }

        container.addView(pagerCellView);
        return pagerCellView;
        //return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager) container).removeView((View) object);

        //super.destroyItem(container, position, object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
        //return super.getItemPosition(object);
    }

    private void showAlertDialog(final String message){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Error!!");
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("You clicked Ok!");
            }
        });
    }

    private void showToast(final String message){

        Toast.makeText(context.getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
