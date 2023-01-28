package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.RecipeServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
@Tag(name = "Рецепты", description = "CRUD-операции и другие эндпоинты для работы с рецептами")

public class RecipeController {
    private final RecipeServices recipeServices;

    public RecipeController(RecipeServices recipeServices) {
        this.recipeServices = recipeServices;
    }

    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe recipe1 = recipeServices.addRecipe(recipe);
        return ResponseEntity.ok(recipe1);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение рецепта по id",description = "Можно искать рецепт по id")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Recipe recipe = recipeServices.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    @Operation(summary = "Получение всех рецептов", description = "Можно получить список всех рецептов")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
            description = "Список всех рецептов был найден",
            content = {
                    @Content(
                            mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                    )
            })
    })
    public ResponseEntity<Void> getAllRecipes() {
        recipeServices.getAllRecipes();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable int id, @RequestBody Recipe newRecipe) {
        Recipe recipe = recipeServices.editRecipe(id, newRecipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        if (recipeServices.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
