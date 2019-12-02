package com.javarnd.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javarnd.recipe.model.Recipe;
import com.javarnd.recipe.service.RecipeService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	RecipeService recipeService;

	/**This resource is accessible only after  Oauth2.0 authentication.
	 * @param recipe
	 * @return 
	 */
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(value = "/addRecipe")
	public ResponseEntity<Object> addRecipe(@RequestBody Recipe recipe) {
		recipeService.addRecipe(recipe);
		return ResponseEntity.ok().build();
	}

	/**
	 * @param recipeId
	 * @return 
	 */
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/approveRecipe/{recipeId}")
	public ResponseEntity<Object> approveRecipe(@PathVariable int recipeId) {
		recipeService.approveRecipe(recipeId);
		return ResponseEntity.ok().build();
	}

	

	/**
	 * @return
	 */
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value = "/recipe")
	public List<Recipe> getAllRecipe() {
		return recipeService.getAllRecipe();
	}
	
	/**
	 * @param recipeId
	 * @return
	 */
	@DeleteMapping("recipe/{recipeId}")
	public ResponseEntity<?> deleteRecipe(@PathVariable(value = "recipeId") int recipeId) {
		recipeService.deleteRecipe(recipeId);
		return ResponseEntity.ok().build();
	}

}
