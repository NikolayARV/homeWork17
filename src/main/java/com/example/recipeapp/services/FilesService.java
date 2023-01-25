package com.example.recipeapp.services;

public interface FilesService {
    boolean saveToFile(String json);


    boolean saveToFileRecipe(String json);

    String readFromFile();


    String readFromFileRecipe();
}
