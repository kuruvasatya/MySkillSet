package com.learning.SpringDataJPA.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UniversityStudent1")
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String branchName;

    public Student(String name, String branchName) {
        this.name = name;
        this.branchName = branchName;
    }
}
