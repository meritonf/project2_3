package com.example.meritonf.projekti_2_3.activities.activities.activities.API;

import com.example.meritonf.projekti_2_3.activities.activities.activities.models.Month;

import java.util.ArrayList;

/**
 * Created by meritonf on 1/8/2018.
 */

public interface MonthsCallback {

    void onMonthsResponse(final ArrayList<Month> months,boolean success);
}
