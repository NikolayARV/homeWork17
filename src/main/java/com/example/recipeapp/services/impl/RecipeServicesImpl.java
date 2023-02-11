package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.FilesService;
import com.example.recipeapp.services.RecipeServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
        try {
            readFromFileRecipe();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Override
    public Path getRecipeMap() throws IOException {
        Path path = filesService.createTempFile("Recipes");
        for (Recipe recipe : recipeMap.values()) {
            try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
                writer.append(recipe.getName() + ". ");
                writer.append("\n");
                writer.append("Время приготовления: " + recipe.getCookingTime() + " минут. ");
                writer.append("\n");
                writer.append("Ингридиенты:" + "\n" + recipe.getIngredients());
                writer.append("\n");
                writer.append("Инструкция приготовления:" + "\n" + recipe.getCookingSteps());
            }
        }
        return path;
    }

    private void saveToFileRecipe() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            filesService.saveToFileRecipe(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    private void readFromFileRecipe() {

        try {
            String json = filesService.readFromFileRecipe();
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}


