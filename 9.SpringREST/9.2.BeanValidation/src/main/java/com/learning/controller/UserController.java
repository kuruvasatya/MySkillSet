package com.learning.controller;

import com.learning.dto.UserRequest;
import com.learning.entity.User;
import com.learning.repositroy.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @PostMapping("/api/v1/users")
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRequest userRequest, BindingResult br) {
        if(br.hasErrors()) {
            List<String> errorMessages = br.getAllErrors().stream()
                    .map((error) -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages.toString());
        } else {
            User userSaved = userRepository.save(new User(userRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
        }
    }
}
