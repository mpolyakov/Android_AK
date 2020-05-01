package com.kt.std.pizzareceipt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaRecipeAdapter extends RecyclerView.Adapter<PizzaRecipeAdapter.PizzaReceipeViewHolder> {
    ArrayList<PizzaReceiptItem> pizzaReceiptItems;
    Context context;

    public PizzaRecipeAdapter(ArrayList<PizzaReceiptItem> pizzaReceiptItems, Context context){
        this.pizzaReceiptItems = pizzaReceiptItems;
        this.context = context;
    }

    @NonNull
    @Override
    public PizzaRecipeAdapter.PizzaReceipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_receipe_item, parent, false);
        PizzaReceipeViewHolder pizzaReceipeViewHolder = new PizzaReceipeViewHolder(view);
        return pizzaReceipeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaReceipeViewHolder holder, int position) {
        PizzaReceiptItem pizzaReceiptItem = pizzaReceiptItems.get(position);
        holder.pizzaImageView.setImageResource(pizzaReceiptItem.getImageResource());
        holder.title.setText(pizzaReceiptItem.getTitle());
        holder.description.setText(pizzaReceiptItem.getDescription());
    }



    @Override
    public int getItemCount() {
        return pizzaReceiptItems.size();
    }

    class PizzaReceipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView pizzaImageView;
        public TextView title;
        public TextView description;

        public PizzaReceipeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);


            pizzaImageView = itemView.findViewById(R.id.pizzaImageView);
            title = itemView.findViewById(R.id.titleImageView);
            description = itemView.findViewById(R.id.descriptionImageView);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            PizzaReceiptItem pizzaReceiptItem = pizzaReceiptItems.get(position);

            Intent intent = new Intent(context, ReceipeActivity.class);
            intent.putExtra("imageResource", pizzaReceiptItem.getImageResource());
            intent.putExtra("title", pizzaReceiptItem.getTitle());
            intent.putExtra("receipt", pizzaReceiptItem.getReceipt());
            context.startActivity(intent);

        }
    }

}
