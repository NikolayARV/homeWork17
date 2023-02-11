package com.example.recipeapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
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
        id = count++;
    }






   @Override
        public String toString() {
           return name + " - " + amount + " " + measureUnit;
       }
}
