package com.learning.SpringDataJPA.dao;

import com.learning.SpringDataJPA.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
