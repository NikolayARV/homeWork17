package com.example.recipeapp.services;

import java.io.File;

public interface FilesService {
    boolean saveToFile(String json);


    File getIngredientDataFile();

    File getRecipeDataFile();

    boolean cleanDataFile();

    boolean saveToFileRecipe(String json);

    String readFromFile();


    String readFromFileRecipe();

    boolean cleanDataFileRecipe();
}
