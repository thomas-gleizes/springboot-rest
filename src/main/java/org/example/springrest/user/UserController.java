package org.example.springrest.user;

import jakarta.validation.Valid;
import org.example.springrest.user.User;
import org.example.springrest.user.UserRepository;

import org.example.springrest.user.LoginForm;
import org.example.springrest.user.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired()
    private UserRepository userRepository;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String > loginUser(@Valid @RequestBody LoginForm loginForm) {
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterForm registerForm) {
        return ResponseEntity.ok("ok");
    }

    @GetMapping(path="")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
