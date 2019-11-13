package com.myapplication.simple_weath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText city;
    private EditText press;
    private EditText temp;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
    }

    private void init() {
        city = findViewById(R.id.editCity);
        temp = findViewById(R.id.editTemp);
        press = findViewById(R.id.editPress);

        button = findViewById(R.id.button);
        button.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


}
