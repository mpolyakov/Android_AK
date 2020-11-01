package com.kt.std.rentateamtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kt.std.rentateamtest.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class UsersAdapter : BaseAdapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return UserViewHolder(v)
    }

    class UserViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {

        init {
            itemView.setOnClickListener {
            }
        }

        override fun bind(item: Any) {
            let {
                item as User
                view.tvName.text = item.firstName
                view.tvSecondName.text = item.lastName
            }
        }
    }


    data class User(
        val id: Int,
        val email: String,
        val firstName: String,
        val lastName: String,
        val avatar: String
    )
}