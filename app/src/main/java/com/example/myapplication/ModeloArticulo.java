package com.example.myapplication;

public class ModeloArticulo {
    String id;
    String name;
    String price;
    String type;
    String des;

    public ModeloArticulo(String id, String name, String price, String type, String des) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.des = des;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getDes() {
        return des;
    }
}
