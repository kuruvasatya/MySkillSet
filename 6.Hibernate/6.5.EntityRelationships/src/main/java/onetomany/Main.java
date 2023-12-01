package onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setBrand("Lenovo");
        Laptop laptop1 = new Laptop();
        laptop1.setBrand("DELL");
        Student student = new Student();
        student.setName("satya");
        student.setLaptops( new ArrayList<>(Arrays.asList(new Laptop[] {laptop,laptop1})));

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(laptop);
        session.save(laptop1);
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
}
