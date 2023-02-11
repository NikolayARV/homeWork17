package com.example.recipeapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class Recipe {
    private  String name;
    private  int cookingTime;
    private Set<Ingredients> ingredients = new HashSet<>();
    private int id;
    public static int count = 1;
    private List<String> cookingSteps;

    public Recipe(String name, int cookingTime, Set<Ingredients> ingredients, List<String> cookingSteps) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.cookingSteps = cookingSteps;
        this.id=count++;
    }



    public Set<Ingredients> getIngredients() {
        return ingredients;
    }



    @Override
    public String toString() {
        return "Recipe{" +
                 ingredients + cookingSteps+
                '}';
    }

}
