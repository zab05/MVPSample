package com.example.cyrus.mvpsample;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainView extends AppCompatActivity implements MainBuilder.View {


    //Views
    @BindView(R.id.button)
    Button btn;
    @BindView(R.id.button2)
    Button btn2;
    @BindView(R.id.button3)
    Button btn3;
    @BindView(R.id.button4)
    Button btn4;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.activity_main)
    RelativeLayout rlSample;

    //String Resources
    @BindString(R.string.app_name) String strAppName;

    //Drawables
    @BindDrawable(R.mipmap.ic_launcher)
    Drawable drawableIcLauncher;



    MainPresenter mainPresenter;

    public final String myPreference = "MainView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenter(this, myPreference);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMsg(editText.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.saveMsg(editText.getText().toString());
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySavedMessage();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.clearSavedData();
            }
        });
    }

    @Override
    public void toastMsg(String msg) {

        if(msg.equals("")){
            Toast.makeText(getApplicationContext(), "Please Enter Anything", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
        Log.d(myPreference, "Toast " + msg);
    }

    @Override
    public void displaySavedMessage(){
        editText.setText(mainPresenter.retrieveSavedMessage());
    }
}
