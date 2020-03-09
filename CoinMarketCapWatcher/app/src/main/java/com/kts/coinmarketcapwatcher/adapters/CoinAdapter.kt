package com.kts.coinmarketcapwatcher.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kts.coinmarketcapwatcher.components.MyViewHolder
import com.kts.coinmarketcapwatcher.model.CoinCap

class CoinAdapter : RecyclerView.Adapter<MyViewHolder>() {
    var mData: List<CoinCap>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int = mData?.size?:0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}