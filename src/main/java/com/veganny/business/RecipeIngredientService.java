package com.veganny.business;

import com.veganny.persistence.RecipeIngredientId;
import com.veganny.persistence.entity.RecipeIngredient;
import com.veganny.persistence.RecipeIngredientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeIngredientService {


    private RecipeIngredientRepository recipeIngredientRepository;

    public List<RecipeIngredient> getAllRecipeIngredients() {
        return recipeIngredientRepository.findAll();
    }

    public RecipeIngredient getRecipeIngredientById(RecipeIngredientId id) {
        return recipeIngredientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RecipeIngredient not found with id: " + id));
    }

    public RecipeIngredient createRecipeIngredient(RecipeIngredient recipeIngredient) {
        return recipeIngredientRepository.save(recipeIngredient);
    }

    public RecipeIngredient updateRecipeIngredient(RecipeIngredientId id, RecipeIngredient recipeIngredientDetails) {
        RecipeIngredient recipeIngredient = getRecipeIngredientById(id);
        recipeIngredient.setQuantity(recipeIngredientDetails.getQuantity());
        return recipeIngredientRepository.save(recipeIngredient);
    }

    public void deleteRecipeIngredient(RecipeIngredientId id) {
        getRecipeIngredientById(id);
        recipeIngredientRepository.deleteById(id);
    }

}
