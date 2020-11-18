package com.kt.std.accessibilityserviceex.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kt.std.accessibilityserviceex.db.Login;

@Database(entities = {Login.class}, version = 1)
public abstract class LoginDatabase extends RoomDatabase {
    public abstract LoginDao getLoginDao();
}
