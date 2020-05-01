package com.kt.std.pizzareceipt;

public class PizzaReceiptItem {
    private int imageResource;
    private String title;
    private String description;
    private String receipt;

    public PizzaReceiptItem(int imageResource, String title, String description, String receipt) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
        this.receipt = receipt;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getReceipt() {
        return receipt;
    }
}
