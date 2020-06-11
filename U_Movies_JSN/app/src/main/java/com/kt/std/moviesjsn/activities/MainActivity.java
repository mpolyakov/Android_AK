package com.kt.std.moviesjsn.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.kt.std.moviesjsn.R;
import com.kt.std.moviesjsn.data.MovieAdapter;
import com.kt.std.moviesjsn.model.Movi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private ArrayList<Movi> movies;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movies = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        getMovies();

    }

    private void getMovies() {
        String url = "http://www.omdbapi.com/?apikey=3f730b87&s=Rocky";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Search");
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.getString("Title");
                        String year = jsonObject.getString("Year");
                        String posterUrl = jsonObject.getString("Poster");

                        Movi movi = new Movi();
                        movi.setTitle(title);
                        movi.setYear(year);
                        movi.setPosterUrl(posterUrl);

                        movies.add(movi);
                    }

                    movieAdapter = new MovieAdapter(MainActivity.this, movies);
                    recyclerView.setAdapter(movieAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);

    }
}
