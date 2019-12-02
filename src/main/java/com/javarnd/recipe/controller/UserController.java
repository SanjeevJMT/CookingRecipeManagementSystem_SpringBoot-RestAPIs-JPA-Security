package com.javarnd.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javarnd.recipe.model.Comment;
import com.javarnd.recipe.model.Recipe;
import com.javarnd.recipe.service.RecipeService;

@RestController
public class UserController {
	@Autowired
	RecipeService recipeService;

	/**
	 * @param recipe
	 * @return 
	 */
	@PostMapping(value = "/addRecipe")
	public ResponseEntity<Object> addRecipe(@RequestBody Recipe recipe) {
		recipeService.addRecipe(recipe);
		return ResponseEntity.ok().build();
	}

	/**
	 * @param recipeId
	 * @param comment  on particular recipe.
	 * @return 
	 */
	@PostMapping(value = "/recipe/{recipeId}/comment")
	public ResponseEntity<Object> addRecipe(@PathVariable int recipeId, @RequestBody Comment comment) {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(recipeId);
		comment.setRecipe(recipe);
		recipeService.addComment(comment);
		return ResponseEntity.ok().build();
	}

	
	/**
	 * @return list of recipe which is approved by admin
	 */
	@GetMapping(value = "/recipe")
	public List<Recipe> getAllRecipe() {
		List<Recipe> recipeList = recipeService.getAllUserRecipe();
		return recipeList;
	}

}
