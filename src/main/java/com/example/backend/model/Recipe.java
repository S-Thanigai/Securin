package com.example.backend.model;

import com.example.backend.config.JsonConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String cuisine;
    private Double rating;
    
    @JsonProperty("prep_time")
    private Integer prepTime;
    
    @JsonProperty("cook_time")
    private Integer cookTime;
    
    @JsonProperty("total_time")
    private Integer totalTime;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    @Convert(converter = JsonConverter.class)
    private Object nutrients;
    
    private String serves;


    public Recipe() {}
    
    public Recipe(String title, String cuisine, Double rating, Integer prepTime, Integer cookTime, Integer totalTime, String description) {
        this.title = title;
        this.cuisine = cuisine;
        this.rating = rating;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.totalTime = totalTime;
        this.description = description;
    }
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getCuisine() {
        return cuisine;
    }
    
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
    
    public Double getRating() {
        return rating;
    }
    
    public void setRating(Double rating) {
        this.rating = rating;
    }
    
    public Integer getPrepTime() {
        return prepTime;
    }
    
    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }
    
    public Integer getCookTime() {
        return cookTime;
    }
    
    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }
    
    public Integer getTotalTime() {
        return totalTime;
    }
    
    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Object getNutrients() {
        return nutrients;
    }
    
    public void setNutrients(Object nutrients) {
        this.nutrients = nutrients;
    }
    
    public String getServes() {
        return serves;
    }
    
    public void setServes(String serves) {
        this.serves = serves;
    }
}