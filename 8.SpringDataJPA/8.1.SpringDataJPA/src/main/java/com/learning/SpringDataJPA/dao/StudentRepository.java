package com.learning.SpringDataJPA.dao;

import com.learning.SpringDataJPA.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Optional<Student> findByName(String name);
}
