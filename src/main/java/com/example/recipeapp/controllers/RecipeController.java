package com.example.recipeapp.controllers;

import com.example.recipeapp.services.RecipeServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")

public class RecipeController {
    private final RecipeServices recipeServices;

    public RecipeController(RecipeServices recipeServices) {
        this.recipeServices = recipeServices;
    }


}
