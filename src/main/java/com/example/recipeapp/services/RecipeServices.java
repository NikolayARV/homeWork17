package com.example.recipeapp.services;

import com.example.recipeapp.model.Recipe;

public interface RecipeServices {

    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(Integer id);

    Recipe editRecipe(int id, Recipe newRecipe);

    boolean deleteRecipe(int id);

    void getAllRecipes();
}
