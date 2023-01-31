package com.example.recipeapp.services;

import com.example.recipeapp.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;

public interface RecipeServices {

    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(Integer id);

    Recipe editRecipe(int id, Recipe newRecipe);

    boolean deleteRecipe(int id);

    void getAllRecipes();

    Path getRecipeMap() throws IOException;
}
