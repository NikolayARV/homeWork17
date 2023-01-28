package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.services.FilesService;
import com.example.recipeapp.services.IngredientsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.TreeMap;

@Service
public class IngredientsServicesImpl implements IngredientsServices {
    final private FilesService filesService;
    private TreeMap<Integer, Ingredients> ingredientsMap = new TreeMap<>();
    private int id = 1;

    public IngredientsServicesImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostConstruct
    private void init() {
       readFromFile();
    }

    @Override

    public Ingredients addIngredient(Ingredients ingredients) {
        ingredientsMap.put(id++, ingredients);
        saveToFile();
        return ingredients;

    }

    @Override
    public Ingredients getByIdIngredient(int id) {
        return ingredientsMap.get(id);
    }

    @Override
    public Ingredients editIngredients(int id, Ingredients newIngredients) {
        if (ingredientsMap.containsKey(id)) {
            ingredientsMap.put(id, newIngredients);
            saveToFile();
            return newIngredients;
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(int id) {
        if (ingredientsMap.containsKey(id)) {
            ingredientsMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public void getAllIngredient() {
        for (Ingredients ingredients : ingredientsMap.values()) {
            System.out.println(ingredients);
        }

    }


    public void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientsMap);
            filesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public void readFromFile() {

        try {
            String json = filesService.readFromFile();
            ingredientsMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Ingredients>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
