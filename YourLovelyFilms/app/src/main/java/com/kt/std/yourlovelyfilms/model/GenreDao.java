package com.kt.std.yourlovelyfilms.model;

import android.provider.MediaStore;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GenreDao {

    @Insert
    void insert(Genre genre);

    @Delete
    void delete(Genre genre);

    @Update
    void update(Genre genre);

    @Query("select * from genres_table")
    LiveData<List<Genre>> getAllGenres();


    
}
