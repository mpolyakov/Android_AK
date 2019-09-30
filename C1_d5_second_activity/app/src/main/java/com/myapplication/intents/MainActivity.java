package com.myapplication.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String USER = "ru.myapp.android.java.USER";
    public static final String GIFT = "ru.myapp.android.java.GIFT";
    public static final String fromWHo = "ru.myapp.android.java.fromWHO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSend(View view) {
        EditText userEditText = findViewById(R.id.editText);
        EditText giftEditText = findViewById(R.id.editText2);
        EditText fromWhoEditText = findViewById(R.id.editText3);
        Intent int1 = new Intent(this, SecondActivity.class);

        int1.putExtra(USER, userEditText.getText().toString());
        int1.putExtra(GIFT, giftEditText.getText().toString());
        int1.putExtra(fromWHo, fromWhoEditText.getText().toString());

        startActivity(int1);


    }
}
