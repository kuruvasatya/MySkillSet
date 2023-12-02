package manytoone2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Laptop lap1 = new Laptop();
        lap1.setBrand("lenovo");
        Laptop lap2 = new Laptop();
        lap2.setBrand("dell");
        Student student = new Student();
        student.setName("satya");
        lap1.setStudent(student);
        lap2.setStudent(student);

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.save(lap1);
        session.save(lap2);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        Student s = session.get(Student.class, 1);
        System.out.println(s);
        session.close();
    }
}
