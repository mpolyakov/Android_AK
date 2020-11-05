package com.kt.std.zaycevtest3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "app_settings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    public static SharedPreferences mSettings;
    public static int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        counter = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
        counter++;
        Log.d("myZayOnc", counter + "");
        if (counter == 3) {
            counter++;
            Toast.makeText(this, "Зайцев нет", Toast.LENGTH_LONG).show();
        }
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, counter);
        editor.apply();

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        counter = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
        counter--;
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, counter);
        editor.apply();

        Log.d("myZayOns", counter + "");
    }

}