package com.example.meritonf.projekti_2_3.activities.activities.activities.API;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.meritonf.projekti_2_3.activities.activities.activities.adapters.MonthsAdapter;
import com.example.meritonf.projekti_2_3.activities.activities.activities.main_activities.MonthsActivity;
import com.example.meritonf.projekti_2_3.activities.activities.activities.models.Month;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by meritonf on 1/8/2018.
 */

public class MonthTask extends AsyncTask<String, Integer, String> {
    private MonthsCallback callback;
    private Context context;

    public MonthTask(MonthsCallback callback){
        this.callback = callback;
    }
    public MonthTask(MonthsCallback callback,Context context){
        this.callback = callback;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String doInBackground(String ... strings){

        final String url = Endpoints.monthsEndpoint;
        final OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        Response response = null;

        try {
            response = client.newCall(request).execute();
            System.out.println("Meriton123");
            System.out.println(response.body());

            final String resStr = response.body().string();
            JSONArray json = new JSONArray(resStr);
            System.out.println("Meriton321");
            System.out.println(json);

            final String stringResponse = response.body().toString();
            return json.toString();
        }catch (IOException exx){
            exx.printStackTrace();
        } catch (JSONException ex) {
            System.out.println("ERRORR");
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        if (response != null){
            onSuccessResponse(response);
        }
    }

    private void onSuccessResponse(String response) {
        ArrayList<Month> monthList = new ArrayList<>();

        System.out.println("qweqweqwe");
        System.out.println(response);


        try{
            final JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i<jsonArray.length(); i++){
                final JSONObject jsonObject = jsonArray.optJSONObject(i);
                monthList.add(new Month(jsonObject));
            }
            callback.onMonthsResponse(monthList, true);
        }catch (JSONException jex){

            jex.printStackTrace();
            callback.onMonthsResponse(null,false);
            showAlertDialog("Error onSuccessResponse!");
        }
    }

    private void showAlertDialog(final String message){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context.getApplicationContext());
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
