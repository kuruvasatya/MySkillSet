package com.learning.controller;

import com.learning.entity.User;
import com.learning.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 1. use of request params
    @GetMapping("/v1/users")
    public ResponseEntity<List<User>> getUserPages(@RequestParam(name = "page", required = false) Integer page,
                                                   @RequestParam(name = "limit", required = false, defaultValue = "5") int limit) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsersFromDB(page, limit));
    }

    // 2. use of PathVariable
    @GetMapping("/v1/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.status(HttpStatus.OK).body(user))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    // 3. create user
    @PostMapping("/v1/users")
    public ResponseEntity<Object> getUser(@RequestBody User user) {
        try {
            User userSaved = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to store use");
        }
    }

    // 4. update user
    @PutMapping("/v1/users/{id}")
    public ResponseEntity<Object> updateUserById(@RequestBody User user, @PathVariable int id) {
        try {
            User updatedUser = userService.updateUser(id, user);
            return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // 5. delete user
    @DeleteMapping("/v1/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        try {
            userService.deleteUserByIdFromDb(id);
            return ResponseEntity.status(HttpStatus.OK).body("User with Id: " + id  + " has been deleted from db");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID: " + id + " is not present in Db");
        }
    }
}
