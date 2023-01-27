package com.example.recipeapp.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EqualsAndHashCode
@ToString
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

    public String getName() {
        return name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCookingSteps() {
        return cookingSteps;
    }

    public void setCookingSteps(List<String> cookingSteps) {
        this.cookingSteps = cookingSteps;
    }
}
