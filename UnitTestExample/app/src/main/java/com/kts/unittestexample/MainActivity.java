package com.kts.unittestexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity  implements Phrases{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BuilderGreetingPhrase builderGreetingPhrase = new BuilderGreetingPhrase(this);
        TextView greet = findViewById(R.id.textView);
        greet.setText(builderGreetingPhrase.get(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
    }

    @Override
    public String getMorning() {
        return getResources().getString(R.string.Morning);
    }

    @Override
    public String getAfternoon() {
        return getResources().getString(R.string.Afternoon);
    }

    @Override
    public String getNight() {
        return getResources().getString(R.string.Night);
    }

    @Override
    public String getEvening() {
        return getResources().getString(R.string.Evening);
    }

    @Override
    public String getHello() {
        return getResources().getString(R.string.Hello);
    }
}
