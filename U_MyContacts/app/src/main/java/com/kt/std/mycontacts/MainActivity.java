package com.kt.std.mycontacts;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAndEditContact(false, null, -1);
            }
        });
    }

    public void addAndEditContact(final boolean isUpdate, Contact contact, long position) {
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
        View view = layoutInflater.inflate(R.layout.add_contact_edit, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(view);

        TextView contactTitleTextView = view.findViewById(R.id.contactTitle);
        final EditText firstNameEditText = view.findViewById(R.id.firstNameEditText);
        final EditText lastNameEditText = view.findViewById(R.id.lastNameEditText);
        final EditText emailEditText = view.findViewById(R.id.emailEditText);
        final EditText phoneNumberEditText = view.findViewById(R.id.phoneNumberEditText);

        contactTitleTextView.setText(!isUpdate ? "Add contact" : "Edit contact");
        if (isUpdate && (contact != null)) {
            firstNameEditText.setText(contact.getFirstName());
            lastNameEditText.setText(contact.getLastName());
            emailEditText.setText(contact.getEmail());
            phoneNumberEditText.setText(contact.getPhoneNumber());

            builder.setCancelable(false).setPositiveButton(isUpdate ? "Update" : "Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (TextUtils.isEmpty(firstNameEditText.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Enter first name", Toast.LENGTH_SHORT).show();
                    } else  if (TextUtils.isEmpty(lastNameEditText.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Enter first name", Toast.LENGTH_SHORT).show();
                    } else  if (TextUtils.isEmpty(emailEditText.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                    } else  if (TextUtils.isEmpty(phoneNumberEditText.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                    } else {
                        if (isUpdate && (contact != null)){

                        }
                    }
                }
            });

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
