package com.geekster.RecipeManagement.repository;

import com.geekster.RecipeManagement.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe,Integer> {
}
