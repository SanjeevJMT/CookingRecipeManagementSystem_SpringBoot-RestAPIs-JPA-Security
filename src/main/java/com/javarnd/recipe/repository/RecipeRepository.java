package com.javarnd.recipe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javarnd.recipe.model.Recipe;

/**
 * @author Developer
 *
 */
@Repository

public interface RecipeRepository extends JpaRepository <Recipe, Integer>{
	
	/**This custom method is built to fetch recipe based on status.
	 * @param status
	 * @return
	 */
	List <Recipe>findByStatus(String status);

}
