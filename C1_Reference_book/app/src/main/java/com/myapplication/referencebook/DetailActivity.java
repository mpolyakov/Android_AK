package com.myapplication.referencebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WebView webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        String resName = "n" + intent.getIntExtra("title", 0);
        Log.i("name", "onCreate: " + resName);

        Context context = getBaseContext();

        String text = readRawTextFile(context, getResources().getIdentifier(resName, "raw", "com.myapplication.referencebook" ));
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

        webView.loadDataWithBaseURL(null, text, "text/html", "en/US", null);
    }

    private String readRawTextFile (Context context, int resID){
        InputStream inputStream = context.getResources().openRawResource(resID);
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(inputReader);
        String line;
        StringBuilder builder = new StringBuilder();

        try {
            while ((line = br.readLine()) != null){
                builder.append(line);
                builder.append("\n");
                builder.append("\r");
            }
        } catch (IOException e){
            System.out.println("Исключение ввода-вывода");
            return null;
        }
        return builder.toString();


    }
}
