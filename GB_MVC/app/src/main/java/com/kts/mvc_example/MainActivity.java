package com.kts.mvc_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {

    private Model mModel;
    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCounter1 = findViewById(R.id.button1);
        btnCounter2 = findViewById(R.id.button2);
        btnCounter3 = findViewById(R.id.button3);
        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);

        mModel = new Model();
        mModel.addObserver(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button1:
                mModel.setElementValueAtIndex(0);
                break;
            case R.id.button2:
                mModel.setElementValueAtIndex(1);
                break;
            case R.id.button3:
                mModel.setElementValueAtIndex(2);
                break;
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        btnCounter1.setText("Количество = " + mModel.getElementValueAtIndex(0));
        btnCounter2.setText("Количество = " + mModel.getElementValueAtIndex(1));
        btnCounter3.setText("Количество = " + mModel.getElementValueAtIndex(2));
    }
}
