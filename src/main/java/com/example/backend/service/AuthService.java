package com.example.backend.service;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String signup(User user) {
        try {

            if (user.getUsername() == null || user.getPassword() == null) {
                return "Invalid input ❌";
            }

            User existingUser = userRepository.findByUsername(user.getUsername());

            if (existingUser != null) {
                return "User already exists ❌";
            }

            userRepository.save(user);
            return "User registered successfully ✅";

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }

    public String login(User user) {
        try {

            User existingUser = userRepository.findByUsername(user.getUsername());

            if (existingUser == null) {
                return "User not found ❌";
            }

            if (!existingUser.getPassword().equals(user.getPassword())) {
                return "Invalid password ❌";
            }

            return "Login successful ✅";

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }
}
