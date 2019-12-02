package com.javarnd.recipe.service;

import java.util.List;

import com.javarnd.recipe.model.Comment;
import com.javarnd.recipe.model.Recipe;

/**
 * @author Developer
 *
 */
public interface RecipeService {

	/**
	 * @return
	 */
	List<Recipe> getAllRecipe();

	/**
	 * @param recipe
	 */
	void addRecipe(Recipe recipe);

	/**
	 * @param recipeId
	 * @return
	 */
	Recipe getRecipeById(int recipeId);

	/**
	 * @param recipeId
	 */
	void approveRecipe(int recipeId);

	/**
	 * @param comment
	 */
	void addComment(Comment comment);

	/**
	 * @return
	 */
	List<Recipe> getAllUserRecipe();

	/**
	 * @param recipeId
	 */
	void deleteRecipe(int recipeId);

}
