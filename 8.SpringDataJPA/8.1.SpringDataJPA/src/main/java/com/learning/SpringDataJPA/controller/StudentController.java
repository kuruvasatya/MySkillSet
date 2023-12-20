package com.learning.SpringDataJPA.controller;

import com.learning.SpringDataJPA.dao.StudentRepository;
import com.learning.SpringDataJPA.entity.Student;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //read
    @GetMapping("/findStudents")
    public List<Student> getAllStudents() {
        return (List<Student>)studentRepository.findAll();
    }

    //read
    @GetMapping("/findStudent/{id}")
    public Student getStudentWithId(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // create
    @GetMapping("/addStudent")
    public Student addStudent() {
        Student student = new Student("new Student", "new branch");
        return studentRepository.save(student);
    }


    //create
    @GetMapping("/addStudents")
    public  List<Student> addStudents() {
        List<Student> studentList = Arrays.asList(
                new Student("Student 1", "branch 1"),
                new Student("Student 2", "branch 2")
        );
        return (List<Student>) studentRepository.saveAll(studentList);
    }


    //update
    @GetMapping("/updateStudent/{id}")
    public Student updateBranch(@PathVariable int id) {

        // the transaction ends after the element is fetched
        Student student = studentRepository.findById(id).orElse(null);
        // now student object is in detached state, any changes done to this object will not reflect in db

        if(student != null) {
           student.setBranchName("updated branch name");
        }
        // student will not be updated in the database
        return student;
    }

    @GetMapping("/updateStudent2/{id}")
    @Transactional
    public Student updateBranchWithTransaction(@PathVariable int id) {

        // the transaction starts
        Student student = studentRepository.findById(id).orElse(null);
        // student object is still in persistent state
        if(student != null) {
            student.setBranchName("updated branch name");
        }
        // the change will reflect in the db as it is part of same transaction.
        // transaction ends
        return student;
    }

    //delete
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);
        return "student deleted";
    }

    @GetMapping("studentByName/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return studentRepository.findByName(name).orElse(null);
    }
}
