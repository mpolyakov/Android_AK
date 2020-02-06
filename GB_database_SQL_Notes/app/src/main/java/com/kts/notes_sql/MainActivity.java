package com.kts.notes_sql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import javax.sql.DataSource;

public class MainActivity extends AppCompatActivity {
    private NoteDataSource notesDataSource;
    private NoteDataReader noteDataReader;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataSource();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NoteAdapter(noteDataReader);
        adapter.setOnMenuItemClickListener(new NoteAdapter.OnMenuItemClickListener() {
            @Override
            public void onItemEditClick(Note note) {
                editElement(note);
            }

            @Override
            public void onItemDeleteClick(Note note) {
                deleteElement(note);

            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initDataSource() {
        notesDataSource = new NoteDataSource(getApplicationContext());
        notesDataSource.open();
        noteDataReader = notesDataSource.getNoteDataReader();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                addElement();
                return true;
            case R.id.menu_clear:
                clearList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void clearList(){
        notesDataSource.deleteAll();
        dataUpdated();
    }

    private void addElement(){
        LayoutInflater factory = LayoutInflater.from(this);
        final View alertView = factory.inflate(R.layout.layout_add_note, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(alertView);
        builder.setTitle(R.string.alert_title_add);
        builder.setNegativeButton(R.string.alert_cancel, null);
        builder.setPositiveButton(R.string.menu_add, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                EditText editTextNote = alertView.findViewById(R.id.editTextNote);
                EditText editTextNoteTitle = alertView.findViewById(R.id.editTextNoteTitle);
                notesDataSource.addNote(editTextNoteTitle.getText().toString(), editTextNote.getText().toString());
                dataUpdated();
            }
        });
        builder.show();
    }

    private void editElement(Note note){
        notesDataSource.editNote(note, "Edited", "Edited title");
        dataUpdated();
    }

    private void deleteElement(Note note){
        notesDataSource.deleteNote(note);
        dataUpdated();
    }

    private void dataUpdated(){
        noteDataReader.Refresh();
        adapter.notifyDataSetChanged();
    }
}
























