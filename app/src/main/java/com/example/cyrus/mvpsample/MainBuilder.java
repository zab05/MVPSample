package com.example.cyrus.mvpsample;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by Cyrus on 07/11/2016.
 */

public class MainBuilder {

    public interface View {
        void toastMsg(String msg);
        void displaySavedMessage();
    }

    public interface Presenter {

// --------------------------------///////////////////////////////// VIEWS //////////////////////////////------------------------------------
        String retrieveSavedMessage();
// --------------------------------///////////////////////////////// MODELS //////////////////////////////------------------------------------
        void clearSavedData();
        void saveMsg(String msg);
    }

    public interface Model {
        void saveText(String msg);
        String retrieveMsg();
        void clearPreference();
    }
}
