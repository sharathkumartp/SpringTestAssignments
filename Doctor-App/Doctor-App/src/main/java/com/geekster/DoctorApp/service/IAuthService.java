package com.geekster.DoctorApp.service;

import com.geekster.DoctorApp.model.AuthenticationToken;
import com.geekster.DoctorApp.model.Patient;
import org.springframework.stereotype.Service;

@Service
public interface IAuthService {
    void saveToken(AuthenticationToken token);
    AuthenticationToken getToken(Patient patient);
    boolean authenticate(String userEmail, String token);
}
