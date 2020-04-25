package com.kt.std.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Good!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral", "Life is life!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Good!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral", "Life is life!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Good!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral", "Life is life!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Good!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral", "Life is life!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Good!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral", "Life is life!"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(recyclerViewItems);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
