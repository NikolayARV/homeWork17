package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.RecipeServices;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RcipeServicesImpl implements RecipeServices {
private Map<Integer, Recipe> recipeMap = new HashMap<>();
private Integer number =1;
    @Override
    public Recipe addRecipe(Recipe recipe) {
       return recipeMap.put(number++, recipe);

    }

    @Override
    public Recipe getRecipe(Integer number) {
        return recipeMap.get(number);
    }
}
