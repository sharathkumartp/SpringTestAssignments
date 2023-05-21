package com.geekster.RecipeManagement.service;

import com.geekster.RecipeManagement.dto.SignInInput;
import com.geekster.RecipeManagement.dto.SignInOutput;
import com.geekster.RecipeManagement.dto.SignUpInput;
import com.geekster.RecipeManagement.dto.SignUpOutput;
import com.geekster.RecipeManagement.model.AuthenticationToken;
import com.geekster.RecipeManagement.model.User;
import com.geekster.RecipeManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationService tokenService;



    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

    public Boolean updateUser(Integer id, User updatedUser) {
        User user=userRepo.findById(id).get();
        if(user != null){
            user.setPassword(updatedUser.getPassword());
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            userRepo.save(user);
            return true;
        }
        return false;
    }

    public SignUpOutput signUp(SignUpInput signUpDto) {
        //check if user exists or not based on email
        User user = userRepo.findFirstByUserEmail(signUpDto.getEmail());//alternative : exist by true/false

        if(user != null)
        {
            throw new IllegalStateException("User already exists!!!!...sign in instead");
        }

        //encryption
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpDto.getPassword());//takes  a string and encrypts it...
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //save the user
        user=new User(signUpDto.getName(),signUpDto.getEmail(),signUpDto.getPhone(),encryptedPassword);

        //token creation and saving

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        return new SignUpOutput("user registered","user created successfully");

    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested =  md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signIn(SignInInput signInDto) {
        //get email
        User user=userRepo.findFirstByUserEmail(signInDto.getUserEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //encrypt the password

        String encryptedPassword = null;

        try {
            encryptedPassword=encryptPassword(signInDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //match it with database encrypted password

        boolean isPasswordValid =encryptedPassword.equals(user.getPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //figure out the token

        AuthenticationToken authToken = tokenService.getToken(user);
        //set up output response

        return new SignInOutput("Authentication Successfull !!!",authToken.getToken());
    }
}
