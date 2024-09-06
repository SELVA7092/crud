package com.example.demo.Service;


import com.example.demo.Model.Enum.Role;
import com.example.demo.Model.Login;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;


    public String register(User user) {
        user.setCreatedOn(LocalDate.now());
        user.setRole(Role.USER);
        userRepository.save(user);
        return " Register Successfully .....! ";
    }

    public ResponseEntity<?> login(Login login) {
        Optional<User> username = userRepository.findByEmail(login.getEmail());
        if (username.isPresent()) {
            if (username.get().getPassword().equals(login.getPassword())) {
                return ResponseEntity.ok("Login successfull.");
            }
            return ResponseEntity.badRequest().body("Password mismatch.");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}

