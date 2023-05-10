package com.example.additem;


import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;
public class ItemModel {


    private String name;
    private int id;
    private String sportType;
    private String location;
    private int price;
    private int privateChecked;

    public ItemModel(String name,int id, String sportType, String location, int price, int privateChecked) {
        this.name = name;
        this.id=id;
        this.sportType = sportType;
        this.location = location;
        this.price = price;
        this.privateChecked = privateChecked;

    }

    public ItemModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int isPrivateChecked() {
        return privateChecked;
    }

    public void setPrivateChecked(int privateChecked) {
        this.privateChecked = privateChecked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}



