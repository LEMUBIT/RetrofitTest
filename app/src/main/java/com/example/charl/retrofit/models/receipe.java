package com.example.charl.retrofit.models;

import com.example.charl.retrofit.models.ingredients;
import com.example.charl.retrofit.models.steps;

import java.util.List;

/**
 * Created by charl on 08/11/2017.
 */

public class receipe {
    private int id;
    private String name;
    private List<ingredients> ingredients;
    private List<steps> steps;
    private int servings;
    private String image;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.example.charl.retrofit.models.ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<com.example.charl.retrofit.models.ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<com.example.charl.retrofit.models.steps> getSteps() {
        return steps;
    }

    public void setSteps(List<com.example.charl.retrofit.models.steps> steps) {
        this.steps = steps;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
