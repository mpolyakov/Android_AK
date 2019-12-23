package com.kts.smsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    String number;
    String message;
    TextInputEditText textInputEditText;
    EditText numberEditText;
    public static TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void send(View view) {
        textInputEditText = findViewById(R.id.txtInputEditTxt);
        message = textInputEditText.getText().toString();
        numberEditText = findViewById(R.id.editText);
        number = numberEditText.getText().toString();

//        String toNumberSms = "smsto:" + number;
//        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(toNumberSms));
//        smsIntent.putExtra("sms_body", message);
//        startActivity(smsIntent);

        SmsManager.getDefault().sendTextMessage(number, null, message, null, null); //немедленная отправка сообщения

    }
}
