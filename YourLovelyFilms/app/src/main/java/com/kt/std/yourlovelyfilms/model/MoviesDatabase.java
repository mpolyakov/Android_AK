package com.kt.std.yourlovelyfilms.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Genre.class, Movie.class}, version = 1)
public abstract class MoviesDatabase extends RoomDatabase {

    private static MoviesDatabase instance;

    public abstract GenreDao getGenreDao();

    public abstract MovieDao getMovieDao();

    public static synchronized MoviesDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MoviesDatabase.class, "moviesDB")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new InitialDataAsyncTask(instance).execute();
        }
    };

    private static class InitialDataAsyncTask extends AsyncTask<Void, Void, Void>{
        private GenreDao genreDao;
        private MovieDao movieDao;

        public InitialDataAsyncTask(MoviesDatabase database){
            genreDao = database.getGenreDao();
            movieDao = database.getMovieDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Genre comedyGenre = new Genre();
            comedyGenre.setGenreName("Comedy");

            Genre romanceGenre = new Genre();
            romanceGenre.setGenreName("Romance");

            genreDao.insert(comedyGenre);
            genreDao.insert(romanceGenre);

            Movie movie1 = new Movie();
            movie1.setMovieName("Bad boys");
            movie1.setMovieDescription("Bad boys go for a walk");
            movie1.setGenreId(1);

            Movie movie2 = new Movie();
            movie2.setMovieName("Ken park");
            movie2.setMovieDescription("About young people");
            movie2.setGenreId(2);

            Movie movie3 = new Movie();
            movie3.setMovieName("fghfg boys");
            movie3.setMovieDescription("fghhfghf h fghfh hgfhfgh fg");
            movie3.setGenreId(1);

            movieDao.insert(movie1);
            movieDao.insert(movie2);
            movieDao.insert(movie3);

            return null;
        }
    }
}
