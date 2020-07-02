package com.kt.std.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kt.std.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    private TextView titleTextView;
//    private TextView authorTextView;

    private ActivityMainBinding activityMainBinding;
    MainActivityButtonsHandler mainActivityButtonsHandler;



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
        mainActivityButtonsHandler = new MainActivityButtonsHandler(this);
        activityMainBinding.setButtonHandler(mainActivityButtonsHandler);
    }

    private Book getCurrentBook() {
        Book book = new Book();
        book.setTitle("Hamlet");
        book.setAuthor("Shakespeare");
        return book;
    }

//    public void onOkClick(View view) {
//
//        Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
//
//    }
//
//    public void onCancelClick(View view) {
//
//        Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
//
//    }

    public class MainActivityButtonsHandler{
        Context context;

        public MainActivityButtonsHandler(Context context) {
            this.context = context;
        }

        public void onOkClick(View view) {

//            Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, OkActivity.class));
        }

        public void onCancelClick(View view) {

//            Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(MainActivity.this, TwoWayActivity.class));
        }
    }
}
























