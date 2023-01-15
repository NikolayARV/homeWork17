package com.example.recipeapp.services.impl;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.services.IngredientsServices;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class IngredientsServicesImpl implements IngredientsServices {
    private Map<Integer, Ingredients> ingredientsMap = new HashMap<>();
    private int number = 1;

    @Override

    public Ingredients addIngredient(Ingredients ingredients) {
        return ingredientsMap.put(number++, ingredients);
    }

    @Override
    public Ingredients getByIdIngredient(int number) {
        return ingredientsMap.get(number);
    }
}
