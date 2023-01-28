package com.example.recipeapp.services;

import com.example.recipeapp.model.Ingredients;


public interface IngredientsServices {

    Ingredients addIngredient(Ingredients ingredients);

    Ingredients getByIdIngredient(int id);

    Ingredients editIngredients(int id, Ingredients newIngredients);

    boolean deleteIngredient(int id);

    void getAllIngredient();

    void saveToFile();

    void readFromFile();
}
