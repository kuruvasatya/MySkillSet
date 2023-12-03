package manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Laptop laptop1 = new Laptop();
        laptop1.setBrand("Lenovo");
        Laptop laptop2 = new Laptop();
        laptop2.setBrand("dell");
        Laptop laptop3 = new Laptop();
        laptop3.setBrand("MAC");

        Student student1 = new Student();
        student1.setName("satya");
        Student student2 = new Student();
        student2.setName("Ganesh");

        student1.setLaptop(new ArrayList<>(Arrays.asList(new Laptop[] {laptop1, laptop2})));
        student2.setLaptop(new ArrayList<>(Arrays.asList(new Laptop[] {laptop1, laptop3})));

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student1);
        session.save(student2);
        session.save(laptop1);
        session.save(laptop2);
        session.save(laptop3);

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        Laptop l1 = session.get(Laptop.class, 1);
        System.out.println(l1 + " " + l1.getStudentList());
        Laptop l2 = session.get(Laptop.class, 2);
        System.out.println(l2 + " " + l2.getStudentList());
        Laptop l3 = session.get(Laptop.class, 3);
        System.out.println(l3 + " "+ l3.getStudentList());
        session.close();
    }
}
