package com.kt.std.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.kt.std.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    private TextView titleTextView;
//    private TextView authorTextView;

    private ActivityMainBinding activityMainBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        titleTextView = findViewById(R.id.titleTextView);
//        authorTextView = findViewById(R.id.authorTextView);
//
//        titleTextView.setText(getCurrentBook().getTitle());
//        authorTextView.setText(getCurrentBook().getAuthor());

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setBook(getCurrentBook());
    }

    private Book getCurrentBook() {
        Book book = new Book();
        book.setTitle("Hamlet");
        book.setAuthor("Shakespeare");
        return book;
    }
}
