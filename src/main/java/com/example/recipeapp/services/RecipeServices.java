package com.example.recipeapp.services;

import com.example.recipeapp.model.Recipe;

public interface RecipeServices {
    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(Integer integer);
}
