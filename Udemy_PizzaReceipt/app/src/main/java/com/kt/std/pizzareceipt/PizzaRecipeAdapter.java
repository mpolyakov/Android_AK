package com.kt.std.pizzareceipt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PizzaRecipeAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_receipe_item, parent, false);
        PizzaReceipeViewHolder pizzaReceipeViewHolder = new PizzaReceipeViewHolder(view);
        return pizzaReceipeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class PizzaReceipeViewHolder extends RecyclerView.ViewHolder {
        public ImageView pizzaImageView;
        public TextView title;
        public TextView description;


        public PizzaReceipeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
