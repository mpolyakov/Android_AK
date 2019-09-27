package com.myapplication.schetchik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mSetCountButton;
    private int mCountKit = 0;
    private TextView mInfoTextView;
    private Button mCountPtitsButton;
    private int mCountPtits = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfoTextView = findViewById(R.id.textView);
        mCountPtitsButton = findViewById(R.id.button_two);
        mSetCountButton = findViewById(R.id.button_alternative);

        mSetCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInfoTextView.setText("Я насчитал " + ++mCountKit + " котят");
            }
        });

        mCountPtitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInfoTextView.setText("Я насчитал " + ++mCountPtits + " птитс");
            }
        });

    }

    public void onClick(View view) {
//        TextView helloTextView = findViewById(R.id.textView);
        mInfoTextView.setText("Hello Kitty!");

    }
}
