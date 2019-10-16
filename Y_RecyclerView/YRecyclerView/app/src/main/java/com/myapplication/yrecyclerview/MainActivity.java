package com.myapplication.yrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");
        initImageBitmaps();


    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Водопад Хавасу");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Трондхейм");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Португалия");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Нац.парк Каменная Гора");


        mImageUrls.add("https://news.rutgers.edu/sites/medrel/files/inline-img/Leslie%20Inline%20Real.jpg");
        mNames.add("Республиканка");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Замерзшее озеро");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("Белопесчаная пустыня");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Австралия");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Уошингтон");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initRecyclerView");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdaptor adapter = new RecyclerViewAdaptor(mNames, mImageUrls,this );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}



//https://www.youtube.com/watch?v=Vyqz_-sJGFk
