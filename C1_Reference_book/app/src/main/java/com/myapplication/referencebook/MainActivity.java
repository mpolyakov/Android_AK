package com.myapplication.referencebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] titles  = {
            "00. Начало",
            "01. Глава 1.",
            "02. Глава 2.",
            "03. Глава 3.",
            "04. Глава 4.",
            "05. Глава 5",
            "06. Глава 6.",
            "07. Глава 7.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, R.layout.simple_layout_item, titles);
        listView.setAdapter(adapter);
//        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailActivity.class);
                intent.putExtra("title", i);
                startActivity(intent);
            }
        });


    }
}
