package com.kts.coinmarketcapwatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kts.coinmarketcapwatcher.adapters.CoinAdapter
import com.kts.coinmarketcapwatcher.api.ServiceGenerator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.android.UI

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : CoinAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CoinAdapter()
        recyclerView.adapter = adapter

    }

    private fun loadCoins()
    {
        launch(UI){
            try {
                val data = ServiceGenerator.serverApi.loadData(10).await()
                adapter.mData = data
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, R.string.no_connection, Toast.LENGTH_LONG).show()
            }
        }
    }
}
