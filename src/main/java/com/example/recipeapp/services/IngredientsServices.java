package com.example.recipeapp.services;

import com.example.recipeapp.model.Ingredients;


public interface IngredientsServices {

    Ingredients addIngredient(Ingredients ingredients);

    Ingredients getByIdIngredient(int number);
}
