package com.example.cyrus.mvpsample;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Cyrus on 26/10/2016.
 */

public class MainPresenter implements MainBuilder.Presenter {

    Context ctx;
    String preferences;
    MainModel mainModel;
    MainView mainView;

    MainPresenter(Context context, String preferences) {
        this.ctx = context;
        this.preferences = preferences;
        mainModel = new MainModel(preferences, ctx);
    }

    //--------------------------------///////////////////////////////// VIEWS //////////////////////////////------------------------------------
    @Override
    public String retrieveSavedMessage() {
        String message;
        if (!mainModel.retrieveMsg().equals("messageKey")) {
            message = mainModel.retrieveMsg();
            return message;
        } else {
            message = "";
            return message;
        }
}

    //--------------------------------///////////////////////////////// MODELS //////////////////////////////------------------------------------
    @Override
    public void saveMsg(String msg) {
        Log.d(preferences, "Preferences " + msg);
        mainModel.saveText(msg);
    }

    @Override
    public void clearSavedData(){
        mainModel.clearPreference();
        Log.d(preferences, "Clear Shared Preferences");
    }
}
