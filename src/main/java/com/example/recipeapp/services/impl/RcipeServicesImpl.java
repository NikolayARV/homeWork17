package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.RecipeServices;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RcipeServicesImpl implements RecipeServices {
private Map<Integer, Recipe> recipeMap = new HashMap<>();
private Integer id =1;
    @Override
    public Recipe addRecipe(Recipe recipe) {
       return recipeMap.put(id++, recipe);

    }

    @Override
    public Recipe getRecipe(Integer number) {
        return recipeMap.get(number);
    }
    @Override
    public Recipe editRecipe(int id, Recipe newRecipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.put(id, newRecipe);
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
}
