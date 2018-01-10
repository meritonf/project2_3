package com.example.meritonf.projekti_2_3.activities.activities.activities.models;

import org.json.JSONObject;

/**
 * Created by meritonf on 1/8/2018.
 */

public class Month {
    private final String id;
    private final String titulli;
    private final String description;
    private final String photoURL;

    public Month(JSONObject jsonObject){
        this.id = jsonObject.optString("id","0");
        this.titulli = jsonObject.optString("titulli", "");
        this.description = jsonObject.optString("description", "");
        this.photoURL = jsonObject.optString("photourl","");
    }

    public String getId() {
        return id;
    }

    public String getTitulli() {
        return titulli;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoURL() {
        return photoURL;
    }
}
