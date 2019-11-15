package com.myapplication.simple_weath;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.myapplication.simple_weath.model.WeatherRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=Moscow,RU&appid=bffab533dd87ce4285f3b672cfb5cf29";
    private EditText city;
    private EditText press;
    private EditText temp;
    private EditText speed;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
    }

    private void init() {
        city = findViewById(R.id.editCity);
        temp = findViewById(R.id.editTemp);
        press = findViewById(R.id.editPress);
        speed = findViewById(R.id.editSpeed);

        button = findViewById(R.id.button);
        button.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                final URL uri = new URL(WEATHER_URL);
                final Handler handler = new Handler();
                new Thread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void run() {
                        HttpsURLConnection urlConnection = null;
                        try {
                            urlConnection = (HttpsURLConnection) uri.openConnection();
                            urlConnection.setRequestMethod("GET");
                            urlConnection.setReadTimeout(10000);
                            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                            String result = in.lines().collect(Collectors.joining("\n"));
                            Gson gson = new Gson();
                            final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    city.setText(weatherRequest.getName());
                                    temp.setText(String.format("%.2f", weatherRequest.getMain().getTemp()));
                                    press.setText(String.format("%d", weatherRequest.getMain().getPressure()));
                                    speed.setText(String.format("%d", weatherRequest.getWind().getSpeed()));
                                }
                            });


                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
    };


}
