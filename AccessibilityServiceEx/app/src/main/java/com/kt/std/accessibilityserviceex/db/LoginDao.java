package com.kt.std.accessibilityserviceex.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LoginDao {

    @Insert
    void insertLogin(Login login);

    @Query("SELECT * FROM logins_table")
    List<Login> getAllLogins();

    @Query("SELECT * FROM logins_table WHERE loginId ==:loginId")
    Login getLogin(long loginId);

    @Update
    void updateLogin(Login login);

    @Delete
    void deleteLogin(Login login);


}
