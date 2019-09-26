package com.myapplication.hello_wrld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

        if (mSomethingEditText.getText().length() == 0) {
            mHelloTextView.setText("Hello Everybody!");
        } else {
            mHelloTextView.setText("Hello " + mSomethingEditText.getText() + "!" );
        }

    }
}
