package com.myapplication.sherlock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int CHOOSE_THIEF = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickQuest(View view) {

        Intent qIntent = new Intent(this, SecondActivity.class);
        startActivityForResult(qIntent, CHOOSE_THIEF);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView answerView = findViewById(R.id.answerTV);

        if (requestCode == CHOOSE_THIEF){
            if (resultCode == RESULT_OK){
                String thiefName = data.getExtras().getString(SecondActivity.THIEF);
                answerView.setText(thiefName);
            } else {
                answerView.setText("");
            }
        }
    }
}
