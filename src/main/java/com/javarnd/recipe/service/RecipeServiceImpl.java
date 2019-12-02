package com.javarnd.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarnd.recipe.model.Comment;
import com.javarnd.recipe.model.Recipe;
import com.javarnd.recipe.repository.CommentRepository;
import com.javarnd.recipe.repository.RecipeRepository;

/**
 * @author Developer
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	CommentRepository commentRepository;

	/* (non-Javadoc)
	 * @see com.javarnd.recipe.service.RecipeService#getAllRecipe()
	 */
	@Override
	public List<Recipe> getAllRecipe() {
		return recipeRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.javarnd.recipe.service.RecipeService#addRecipe(com.javarnd.recipe.model.Recipe)
	 */
	@Override
	public void addRecipe(Recipe recipe) {
		recipeRepository.save(recipe);

	}

	/* (non-Javadoc)
	 * @see com.javarnd.recipe.service.RecipeService#getRecipeById(int)
	 */
	@Override
	public Recipe getRecipeById(int recipeId) {
		Recipe recipe=recipeRepository.getOne(recipeId);
		return recipe;
	}

	/* (non-Javadoc)
	 * @see com.javarnd.recipe.service.RecipeService#approveRecipe(int)
	 */
	@Override
	public void approveRecipe(int recipeId) {
		Recipe recipe = recipeRepository.getOne(recipeId);
		recipe.setStatus("Approved");
		recipeRepository.save(recipe);

	}

	/* (non-Javadoc)
	 * @see com.javarnd.recipe.service.RecipeService#addComment(com.javarnd.recipe.model.Comment)
	 */
	@Override
	public void addComment(Comment comment) {

		commentRepository.save(comment);
	}

	/* (non-Javadoc)
	 * @see com.javarnd.recipe.service.RecipeService#getAllUserRecipe()
	 */
	@Override
	public List<Recipe> getAllUserRecipe() {

		return recipeRepository.findByStatus("Approved"); // fetches only admin approved recipes
	}

	/* (non-Javadoc)
	 * @see com.javarnd.recipe.service.RecipeService#deleteRecipe(int)
	 */
	@Override
	public void deleteRecipe(int recipeId) {
		recipeRepository.deleteById(recipeId);
	}

}
