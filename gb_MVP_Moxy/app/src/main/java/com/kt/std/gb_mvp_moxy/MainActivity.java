package com.kt.std.gb_mvp_moxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button button1;
    Button button2;
    Button button3;

    @InjectPresenter
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.button1IsPushed();
            }
        });

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.button2IsPushed();
            }
        });

        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.button3IsPushed();
            }
        });
    }


    @Override
    public void setTextToButton1(int value) {
        button1.setText("Количество = " + value);
    }

    @Override
    public void setTextToButton2(int value) {
        button2.setText("Количество = " + value);
    }

    @Override
    public void setTextToButton3(int value) {
        button3.setText("Количество = " + value);
    }
}