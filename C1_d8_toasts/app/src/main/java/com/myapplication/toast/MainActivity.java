package com.myapplication.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
//        Toast toast = Toast.makeText(this, "Пора покормить кота!", Toast.LENGTH_LONG);
//        toast.setGravity(0, 10, -5);
//        toast.show();

//        Toast toast2 = Toast.makeText(this, R.string.eda, Toast.LENGTH_SHORT);
//        toast2.setGravity(Gravity.TOP, 0,0);
//        toast2.show();
//
//
//        Toast toast3 = Toast.makeText(getApplicationContext(),R.string.eda, Toast.LENGTH_LONG);
//        toast3.setGravity(Gravity.TOP, 0, 0);
//        LinearLayout toastContainer = (LinearLayout) toast3.getView();
//        ImageView makiView = new ImageView(getApplicationContext());
//        makiView.setImageResource(R.drawable.maki);
//        toastContainer.addView(makiView, 0);
//        toast3.show();

        Toast toast4 = Toast.makeText(getApplicationContext(),"Какой-то текст для тоста", Toast.LENGTH_LONG);
        toast4.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast4.getView();
        toastContainer.setBackgroundColor(Color.TRANSPARENT);
        toast4.show();




    }
}
