package com.github.beliakou.expenses.controller;

import com.github.beliakou.expenses.domain.User;
import com.github.beliakou.expenses.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("name") String username) {
        return this.userRepository.findUser(username).orElseThrow(RuntimeException::new);
    }
}
