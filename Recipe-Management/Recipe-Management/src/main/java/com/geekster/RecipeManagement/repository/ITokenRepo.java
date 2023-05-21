package com.geekster.RecipeManagement.repository;

import com.geekster.RecipeManagement.model.AuthenticationToken;
import com.geekster.RecipeManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findByUser(User user);
}
