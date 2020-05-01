package com.kt.std.pizzareceipt;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PizzaReceiptItem> pizzaReceipItems = new ArrayList<>();
        pizzaReceipItems.add(new PizzaReceiptItem(R.drawable.pizza1, Utils.PIZZA1_TITLE, Utils.PIZZA1_DESCRIPTION , Utils.PIZZA1_RECEIPT));
        pizzaReceipItems.add(new PizzaReceiptItem(R.drawable.pizza2, Utils.PIZZA2_TITLE, Utils.PIZZA2_DESCRIPTION , Utils.PIZZA2_RECEIPT));
        pizzaReceipItems.add(new PizzaReceiptItem(R.drawable.pizza3, Utils.PIZZA3_TITLE, Utils.PIZZA3_DESCRIPTION , Utils.PIZZA3_RECEIPT));
        pizzaReceipItems.add(new PizzaReceiptItem(R.drawable.pizza4, Utils.PIZZA4_TITLE, Utils.PIZZA4_DESCRIPTION , Utils.PIZZA4_RECEIPT));
        pizzaReceipItems.add(new PizzaReceiptItem(R.drawable.pizza5, Utils.PIZZA5_TITLE, Utils.PIZZA5_DESCRIPTION , Utils.PIZZA5_RECEIPT));
        pizzaReceipItems.add(new PizzaReceiptItem(R.drawable.pizza6, Utils.PIZZA6_TITLE, Utils.PIZZA6_DESCRIPTION , Utils.PIZZA6_RECEIPT));
        pizzaReceipItems.add(new PizzaReceiptItem(R.drawable.pizza7, Utils.PIZZA7_TITLE, Utils.PIZZA7_DESCRIPTION , Utils.PIZZA7_RECEIPT));

        recyclerView = findViewById(R.id.recylclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new PizzaRecipeAdapter(pizzaReceipItems, this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}
