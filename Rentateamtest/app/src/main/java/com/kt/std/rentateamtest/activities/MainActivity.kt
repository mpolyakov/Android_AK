package com.kt.std.rentateamtest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kt.std.rentateamtest.R
import com.kt.std.rentateamtest.fragments.UserListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, UserListFragment(), null)
                .commit()
        }
    }
}