package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.services.IngredientsServices;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientsServicesImpl implements IngredientsServices {
    private Map<Integer, Ingredients> ingredientsMap = new HashMap<>();
    private int id = 1;

    @Override

    public Ingredients addIngredient(Ingredients ingredients) {
        return ingredientsMap.put(id++, ingredients);
    }

    @Override
    public Ingredients getByIdIngredient(int id) {
        return ingredientsMap.get(id);
    }

    @Override
    public Ingredients editIngredients(int id, Ingredients newIngredients) {
        if (ingredientsMap.containsKey(id)) {
            ingredientsMap.put(id, newIngredients);
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
    public void getAllIngredient () {
        for (Ingredients ingredients : ingredientsMap.values()) {
            System.out.println(ingredients);
        }

    }
}
