package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.services.IngredientsServices;
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

    @GetMapping
    public ResponseEntity<Void> getAllIdIngredient() {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredients> editIngredients(@PathVariable int id, @RequestBody Ingredients newIngredient) {
        Ingredients ingredients = ingredientsServices.editIngredients(id, newIngredient);
        if (ingredients == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredients);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        if (ingredientsServices.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
