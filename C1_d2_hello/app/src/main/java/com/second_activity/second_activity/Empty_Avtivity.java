package com.second_activity.second_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.myapplication.second_activity.R;

public class Empty_Avtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty__avtivity);
    }

    public void noClick4Finish(View view) {
        finish();
    }
}
