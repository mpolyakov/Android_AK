package com.myapplication.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCounter = 0;
    private TextView mtextView;
    public static final String APP_PREFERENCES = "mysettings";
    private static final String KEY_counter = "counter";
    private SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtextView = findViewById(R.id.textView);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void onClick(View view) {
        mCounter++;
        mtextView.setText(((Integer) mCounter).toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(KEY_counter, mCounter);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSettings.contains(KEY_counter)){
            mCounter = mSettings.getInt(KEY_counter, 0);
            mtextView.setText("" + mCounter);
        }

    }
}
