package manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        laptop.setBrand("Lenovo");
        Laptop laptop1 = new Laptop();
        laptop1.setBrand("DELL");
        Student student = new Student();
        student.setName("satya");
        laptop.setStudent(student);
        laptop1.setStudent(student);

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

        session = sessionFactory.openSession();
        System.out.println(session.get(Laptop.class, 1));
        session.close();
    }
}
