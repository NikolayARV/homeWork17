package com.example.recipeapp.controllers;

import com.example.recipeapp.model.Ingredients;
import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.services.IngredientsServices;
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
@RequestMapping("/ingredients")
@Tag(name = "Ингридиенты", description = "CRUD-операции и другие эндпоинты для работы с ингридиентами")
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
    @Operation(summary = "Получение ингридиента по id",description = "Можно искать ингридиент по id")
    public ResponseEntity<Ingredients> getByIdIngredient(@PathVariable int id) {
        Ingredients ingredients = ingredientsServices.getByIdIngredient(id);
        if (ingredients == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping
    @Operation(summary = "Получение всех ингридиентов",description = "Можно вывести все ингридиенты")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "Список всех ингридиентов был найден",
                    content = {
                            @Content(
                                    mediaType = "aplication/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredients.class))
                            )
                    })
    })
    public ResponseEntity<Void> getAllIdIngredient() {
        ingredientsServices.getAllIngredient();
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
