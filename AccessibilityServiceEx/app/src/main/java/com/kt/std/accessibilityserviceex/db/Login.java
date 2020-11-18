package com.kt.std.accessibilityserviceex.db;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "logins_table")
public class Login {

    @PrimaryKey(autoGenerate = true)
    private long loginId;

    private String login;

    @Ignore
    public Login() {
    }

    public Login(String login) {
        this.login = login;
    }

    public long getLoginId() {
        return loginId;
    }

    public void setLoginId(long loginId) {
        this.loginId = loginId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
