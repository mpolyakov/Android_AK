package com.second_activity.second_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.myapplication.second_activity.R;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;
    private EditText mSomethingEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = findViewById(R.id.textView);
        mSomethingEditText = findViewById(R.id.editText);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    public void onClickThirdPage(View view) {
        Intent intent3 = new Intent(this, Birthday_Activity.class);
        startActivity(intent3);
    }

    public void onClickToFourPage(View view) {
        Intent intent4 = new Intent(this, Empty_Avtivity.class);
        startActivity(intent4);
    }
}
