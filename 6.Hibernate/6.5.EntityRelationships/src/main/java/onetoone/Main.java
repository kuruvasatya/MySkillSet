package onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setName("Lenovo");
        Student student = new Student();
        student.setName("satya");
        student.setLaptop(laptop);

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(laptop);
        session.save(student);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        Student s = session.get(Student.class, 1);
        System.out.println(s);
        session.close();
    }
}
