package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String args[]) {

        Student student1 = new Student();
        student1.setName("satya");

        Student student2 = new Student();
        student2.setName("Ganesh");

        Course course1 = new Course();
        course1.setName("Java");
        course1.setCredits(5);

        Course course2 = new Course();
        course2.setName("Hibernate");
        course2.setCredits(6);

        Course course3 = new Course();
        course3.setName("Spring Boot");
        course3.setCredits(10);

        course1.setStudents(Arrays.asList(new Student[] {student1}));
        course2.setStudents(Arrays.asList(new Student[] {student1, student2}));
        course3.setStudents(Arrays.asList(new Student[] {student2}));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course1);
        em.persist(course2);
        em.persist(course3);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Course> query = em.createQuery("from Course s JOIN FETCH s.students", Course.class);
        List<Course> courseList = query.getResultList();
        System.out.println(courseList);
        em.getTransaction().commit();
        em.close();

    }
}
