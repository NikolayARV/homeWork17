package com.example.recipeapp.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Ingredients {
    private  String name;
    private int amount;
    private  String measureUnit;
    private  int  id;
    public static int count = 1;

    public Ingredients(String name, int amount, String measureUnit) {
        this.name = name;
        this.amount = amount;
        this.measureUnit = measureUnit;
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }
}
