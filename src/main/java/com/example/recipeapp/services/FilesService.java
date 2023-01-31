package com.example.recipeapp.services;

import java.io.File;
import java.nio.file.Path;

public interface FilesService {
    boolean saveToFile(String json);


    File getIngredientDataFile();

    Path createTempFile(String suffix);

    File getRecipeDataFile();

    

    boolean saveToFileRecipe(String json);

    String readFromFile();


    String readFromFileRecipe();


    boolean cleanDataFile();

    boolean cleanDataFileRecipe();
}
