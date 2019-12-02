package com.javarnd.recipe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author Developer
 *
 */
@Entity
public class Recipe implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2659125606752211193L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int recipeId;
	private String recipeName;
	private String recipeDetails;
	private String status;

	
	
	
	
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRecipeDetails() {
		return recipeDetails;
	}
	public void setRecipeDetails(String recipeDetails) {
		this.recipeDetails = recipeDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
