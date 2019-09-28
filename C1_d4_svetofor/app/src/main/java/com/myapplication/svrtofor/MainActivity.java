package com.myapplication.svrtofor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout mConstrainedLayout;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConstrainedLayout = findViewById(R.id.constrainedLayout);
        mTextView = findViewById(R.id.textView);

        Button yellowButton = findViewById(R.id.buttonYellow);
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText(R.string.Yellow);
                mConstrainedLayout.setBackgroundColor(getResources().getColor(R.color.yellowColor));
            }
        });
}

    public void onRedButtonClick(View view) {
        mTextView.setText(R.string.red);
        mConstrainedLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.redColor));

    }

    public void onGreenButtonClick(View view) {
        mTextView.setText(R.string.Green);
        mConstrainedLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.greenColor));
    }
}
