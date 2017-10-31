package com.wenson.litepal.bean;

import android.util.Log;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/10/31.
 */

public class Book extends DataSupport {
    private static final String TAG = "Book";
    private int id;
    private double price;
    private int pages;
    private String name;
    private String author;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book: id = " + getId() + ",price = " + getPrice() + ",pages = " + getPages() +
                ",name = " + getName() + ",author = " + getAuthor());
        Log.d(TAG, "toString: " +  builder.toString());
        return builder.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
