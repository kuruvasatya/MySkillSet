package com.learning.service;

import com.learning.entity.User;
import com.learning.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        List<User> users = IntStream.rangeClosed(1,10)
                .mapToObj(i -> new User("User" + i))
                .collect(Collectors.toList());
        userRepository.saveAll(users);
    }

    public List<User> getAllUsersFromDB() {
        return userRepository.findAll();
    }

    public List<User> getAllUsersFromDB(Integer page, int limit) {
        if(page == null)
            return userRepository.findAll();
        else
            return userRepository.findAll(PageRequest.of(page, limit)).getContent();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User user) {
        return userRepository.findById(id)
                .map(exisingUser -> {
                    exisingUser.setName(user.getName());
                    return userRepository.save(exisingUser);
                }).orElseThrow(() ->new RuntimeException("User not found"));

    }

    public void deleteUserByIdFromDb(int id) {
        userRepository.findById(id).ifPresentOrElse(
                (user) -> userRepository.deleteById(id),
                () -> new RuntimeException("User not found!")
        );

    }
}
