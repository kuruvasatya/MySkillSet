package com.learning.entity;

import com.learning.dto.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="User_BeanValidation")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String email;
    int age;

    public User(UserRequest userRequest) {
        this.name = userRequest.getName();
        this.age = userRequest.getAge();
        this.email = userRequest.getEmail();
    }
}
