package com.kt.std.ipartnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kt.std.ipartnertest.model.api.ApiHolder;
import com.kt.std.ipartnertest.model.api.INotesSource;
import com.kt.std.ipartnertest.model.entity.ListNotes;
import com.kt.std.ipartnertest.model.entity.Note;
import com.kt.std.ipartnertest.model.entity.SessionResponse;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Note> listNotesArrayList;
    private String session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSession();
        getNotes();
    }

    private void getSession() {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody requestBody = RequestBody.create(mediaType, "a=new_session");

        INotesSource notesSource = ApiHolder.getApi();
        Call<SessionResponse> call = notesSource.getSession(requestBody);
        call.enqueue(new Callback<SessionResponse>() {
            @Override
            public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                SessionResponse sessionResponse = response.body();

                session = sessionResponse.getData().getSession();
                Log.d("resultNotes", session);
            }

            @Override
            public void onFailure(Call<SessionResponse> call, Throwable t) {
                Log.d("resultNotes", t.getMessage());
            }
        });


    }

    private void getNotes() {

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "a=get_entries&session=pbkd2rcB43ctkhTHB9");

        INotesSource notesSource = ApiHolder.getApi();

        Call<ListNotes> call = notesSource.getListNotes(body);
        call.enqueue(new Callback<ListNotes>() {
            @Override
            public void onResponse(Call<ListNotes> call, Response<ListNotes> response) {
                ListNotes listNotes = response.body();
                if (listNotes != null && listNotes.getData() != null) {
                    listNotesArrayList = (ArrayList<Note>) listNotes.getData().get(0);
                }

                for (Note note : listNotesArrayList) {
                    Log.d("resultNotes", note.getBody());
                }

            }

            @Override
            public void onFailure(Call<ListNotes> call, Throwable t) {
                Log.d("resultNotes", t.getMessage());

            }
        });
    }

}
