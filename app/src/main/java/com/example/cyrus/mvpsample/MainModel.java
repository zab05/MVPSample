package com.example.cyrus.mvpsample;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Cyrus on 26/10/2016.
 */

public class MainModel implements MainBuilder.Model {

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    Context ctx;
    String preference;


    MainModel(String preference, Context context){
        this.ctx = context;
        this.preference = preference;
        sharedpreferences = context.getSharedPreferences(preference, context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }

    @Override
    public void saveText(String msg){
        editor.putString("messageKey",msg);
        editor.commit();
    }
    @Override
    public String retrieveMsg(){
        return sharedpreferences.getString("messageKey","messageKey");
    }

    @Override
    public void clearPreference(){
        editor.clear();
        editor.commit();
    }
}
