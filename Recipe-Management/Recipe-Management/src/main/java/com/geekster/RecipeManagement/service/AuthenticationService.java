package com.geekster.RecipeManagement.service;

import com.geekster.RecipeManagement.model.AuthenticationToken;
import com.geekster.RecipeManagement.model.User;
import com.geekster.RecipeManagement.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    ITokenRepo tokenRepo;

    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepo.findByUser(user);
    }
}
