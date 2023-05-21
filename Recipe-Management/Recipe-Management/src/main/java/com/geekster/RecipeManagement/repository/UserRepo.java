package com.geekster.RecipeManagement.repository;

import com.geekster.RecipeManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String email);
}
