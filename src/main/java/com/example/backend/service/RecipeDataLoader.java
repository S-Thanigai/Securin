package com.example.backend.service;

import com.example.backend.model.Recipe;
import com.example.backend.repository.RecipeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RecipeDataLoader {

    private static final Logger logger = LoggerFactory.getLogger(RecipeDataLoader.class);
    private final RecipeRepository recipeRepository;
    private final ObjectMapper objectMapper;

    public RecipeDataLoader(RecipeRepository recipeRepository,
                            ObjectMapper objectMapper) {
        this.recipeRepository = recipeRepository;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadRecipes() {
        try {

            if (recipeRepository.count() > 0) {
                logger.info("Recipes already loaded. Skipping.");
                return;
            }

            logger.info("Loading recipes from US_recipes_null.json...");
            InputStream inputStream =
                    new ClassPathResource("US_recipes_null.json").getInputStream();

            Map<String, Recipe> recipesMap = objectMapper.readValue(
                    inputStream,
                    new TypeReference<Map<String, Recipe>>() {}
            );

            recipeRepository.saveAll(recipesMap.values());

            logger.info("Recipes loaded successfully! Total: " + recipesMap.size());

        } catch (Exception e) {
            logger.error("Failed to load recipes", e);
        }
    }
}