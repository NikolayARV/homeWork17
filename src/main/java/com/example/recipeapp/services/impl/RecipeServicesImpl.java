package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.FilesService;
import com.example.recipeapp.services.RecipeServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.TreeMap;

@Service
public class RecipeServicesImpl implements RecipeServices {

    final private FilesService filesService;
    private TreeMap<Integer, Recipe> recipeMap = new TreeMap<>();
    private Integer id = 1;

    public RecipeServicesImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostConstruct
    private void init() {
        readFromFileRecipe();
    }


    @Override

    public Recipe addRecipe(Recipe recipe) {
        recipeMap.put(id++, recipe);
        saveToFileRecipe();
        return recipe;

    }

    @Override
    public Recipe getRecipe(Integer number) {
        return recipeMap.get(number);
    }

    @Override
    public Recipe editRecipe(int id, Recipe newRecipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.put(id, newRecipe);
            saveToFileRecipe();
            return newRecipe;
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(int id) {
        if (recipeMap.containsKey(id)) {
            recipeMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public void getAllRecipes() {
        for (Recipe recipe : recipeMap.values()) {
            System.out.println(recipe);
        }

    }

    public void saveToFileRecipe() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            filesService.saveToFileRecipe(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public void readFromFileRecipe() {

        try {
            String json = filesService.readFromFileRecipe();
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}


