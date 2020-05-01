package com.kt.std.pizzareceipt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipe);

        TextView title = findViewById(R.id.titleTextView);
        TextView recipe = findViewById(R.id.receipTextView2);

        Intent intent = getIntent();
        if (intent != null) {
            title.setText(intent.getStringExtra("title"));
            recipe.setText(intent.getStringExtra("receipt"));

        }
    }
}
