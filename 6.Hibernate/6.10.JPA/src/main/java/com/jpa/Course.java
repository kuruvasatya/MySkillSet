package com.jpa;

import javax.persistence.*;
import java.util.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;
    private String name;
    private int credits;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "STUDENT_COURSE_MAPPING",
        joinColumns = @JoinColumn(name = "Course_Id"), inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", students=" + students +
                '}';
    }
}
