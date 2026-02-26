package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Recipe;
import com.example.backend.repository.RecipeRepository;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll().stream().toList();
    }
    public Recipe addRecipe(Recipe recipe)
    {
        return recipeRepository.save(recipe);
    }
    public List<Recipe> getTopRecipes(int limit){
        return recipeRepository.findTopRecipesByRating(limit);
    }
}
