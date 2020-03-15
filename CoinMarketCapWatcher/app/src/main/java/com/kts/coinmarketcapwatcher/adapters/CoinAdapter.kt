package com.kts.coinmarketcapwatcher.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kts.coinmarketcapwatcher.R
import com.kts.coinmarketcapwatcher.components.MyViewHolder
import com.kts.coinmarketcapwatcher.model.CoinCap
import kotlinx.android.synthetic.main.item_coin.view.*

class CoinAdapter : RecyclerView.Adapter<MyViewHolder>() {
    var mData: List<CoinCap>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent,false))
    }

    override fun getItemCount(): Int = mData?.size?:0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        mData?.let {
            val coin = it[position]
            holder.view.tvSymbol.text = coin.symbol
            holder.view.tvName.text = coin.name
            holder.view.tvPrice.text = "$${coin.price_usd}"
            holder.view.tvPriceChange.text = if (coin.percent_change_24h > 0) "+${coin.percent_change_24h}%"  else "${coin.percent_change_24h}%"
        }

    }
}