package com.myapplication.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.myapplication.intents.MainActivity.GIFT;
import static com.myapplication.intents.MainActivity.USER;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String user = null;
        String gift = null;
        String fromWho = null;

        user = getIntent().getExtras().getString(USER);
        gift = getIntent().getExtras().getString(GIFT);
        fromWho = getIntent().getStringExtra(MainActivity.fromWHo);

        TextView infoTextView = findViewById(R.id.infoTextView);
        infoTextView.setText(user + " вам передали " + gift + ". От " + fromWho);


    }
}
