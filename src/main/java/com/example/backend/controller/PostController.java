package com.example.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend.model.Recipe;
import com.example.backend.service.RecipeService;

@Controller
public class PostController {
    @Autowired
    private RecipeService recipeService;
    
    
    @GetMapping("/getRecipes")
    public ResponseEntity<List<Recipe>> getRecipes() {
        return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
    }
    
    @PostMapping("/addRecipe")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(savedRecipe);
    }
    
    @GetMapping("/recipes/top")
    public ResponseEntity<Map<String, List<Recipe>>> getTopRecipes(@RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<Recipe> topRecipes = recipeService.getTopRecipes(limit);
        Map<String, List<Recipe>> response = new HashMap<>();
        response.put("data", topRecipes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
