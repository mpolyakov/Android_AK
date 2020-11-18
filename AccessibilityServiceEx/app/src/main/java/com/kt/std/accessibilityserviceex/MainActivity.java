package com.kt.std.accessibilityserviceex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;

import com.kt.std.accessibilityserviceex.db.Login;
import com.kt.std.accessibilityserviceex.db.LoginDatabase;
import com.kt.std.accessibilityserviceex.service.MyAccessibilityService;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    LoginDatabase loginDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginDatabase = Room.databaseBuilder(getApplicationContext(), LoginDatabase.class, "LoginDB").build();
        textView = findViewById(R.id.tvLogin);
        String login = getIntent().getStringExtra("loginName");

        if (login != null) {
            textView.setText(login);
            addLogin(new Login(login));
        }

    }

    public void buttonClick(View view) {
        MyAccessibilityService.COUNT = 0;

        AccessibilityManager accessibilityManager = (AccessibilityManager) this.getSystemService(Context.ACCESSIBILITY_SERVICE);
        List<AccessibilityServiceInfo> accessibilityServiceList = accessibilityManager
                .getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK);

        if ((accessibilityServiceList.toString()).contains("MyAccessibilityService")) {

            launchInstagram();

        } else {
            Intent intent = new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivityForResult(intent, 0);
        }
    }

    private void launchInstagram() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
        if (launchIntent != null) {
            launchIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(launchIntent);
        }
    }

    private void addLogin(Login login) {
        new AddLoginAsyncTask().execute(login);
    }

    private class AddLoginAsyncTask extends AsyncTask<Login, Void, Void> {

        @Override
        protected Void doInBackground(Login... logins) {
            loginDatabase.getLoginDao().insertLogin(logins[0]);
            return null;
        }
    }


}