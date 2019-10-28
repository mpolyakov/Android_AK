package com.myapplication.material_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public TextInputEditText login;
    public TextInputEditText password;

    Pattern checkLogin = Pattern.compile("^[A-Z][a-z]+$");
    Pattern checkPassword = Pattern.compile("^.{6,}$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.textInputEditText1);
        password = findViewById(R.id.textInputEditText2);

        login.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) return;
                TextView tv = (TextView) view;
                validate(tv, checkPassword, "Это не имя");
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) return;
                TextView tv = (TextView) view;
                validate(tv, checkPassword, "Пароль слишком простой");

            }
        });
    }

    private void validate(TextView tv, Pattern check, String message) {
        String value = tv.getText().toString();

        if (check.matcher(value).matches()){
            hideError(tv);
        }
        else {
            showError(tv, message);

        }
    }

    private void showError(TextView tv, String message) {
        tv.setError(message);
    }

    private void hideError(TextView tv) {
        tv.setError(null);

    }
}
