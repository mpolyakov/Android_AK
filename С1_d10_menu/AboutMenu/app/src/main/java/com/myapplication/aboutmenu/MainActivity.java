package com.myapplication.aboutmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        TextView textView = findViewById(R.id.textview);

        switch (id){
            case R.id.action_settings:
                textView.setText("Вы выбрали настройки");
                break;
            case R.id.action_cat1:
                textView.setText("Вы выбрали мэйл");
                break;
            case R.id.action_cat2:
                textView.setText("Вы выбрали фемале");
                break;
            case R.id.action_cat3:
                textView.setText("Вы выбрали бэбика");

        }



        return super.onOptionsItemSelected(item);
    }
}


