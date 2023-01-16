package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.services.IngredientsServices;
import com.example.recipeapp.services.RecipeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private final IngredientsServices ingredientsServices;

    public IngredientsController(IngredientsServices ingredientsServices) {
        this.ingredientsServices = ingredientsServices;
    }

    @PostMapping
    public ResponseEntity<Ingredients> addIngredient(@RequestBody Ingredients ingredients) {
        Ingredients ingredient = ingredientsServices.addIngredient(ingredients);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredients> getByIdIngredient(@PathVariable int id) {
        Ingredients ingredients = ingredientsServices.getByIdIngredient(id);
        if (ingredients == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredients);
    }
}
