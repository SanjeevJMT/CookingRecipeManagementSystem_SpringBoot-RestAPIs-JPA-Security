package com.javarnd.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javarnd.recipe.model.Comment;

/**
 * @author Developer
 *
 */
public interface CommentRepository extends JpaRepository <Comment, Integer>{

}
