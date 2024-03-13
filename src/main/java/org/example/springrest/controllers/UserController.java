package org.example.springrest.controllers;

import jakarta.validation.Valid;
import org.example.springrest.models.User;
import org.example.springrest.repositories.UserRepository;

import org.example.springrest.validations.LoginForm;
import org.example.springrest.validations.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired()
    private UserRepository userRepository;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<User> loginUser(@RequestBody LoginForm loginForm) {
        User user = userRepository.findByEmail(loginForm.getEmail());

        if (!user.comparePassword(loginForm.getPassword())) {
            return ResponseEntity.badRequest().body(user);
        }

        return ResponseEntity.ok(new User());
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterForm registerForm) {
        User user = new User(registerForm);
        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @GetMapping(path="")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
