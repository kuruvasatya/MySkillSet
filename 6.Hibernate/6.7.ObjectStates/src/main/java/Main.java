import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String args[]) {

        UsersTest test = new UsersTest();
        test.setName("satya");
        test.setSalary(12000);

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(UsersTest.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // object is still in transient state
        test.setSalary(15000);
        session.getTransaction().commit();

        session = sessionFactory.openSession();
        session.beginTransaction();
        test.setSalary(15000); // transient
        session.save(test); // persistent state
        test.setSalary(18000); //transient state
        session.getTransaction().commit();

        session = sessionFactory.openSession();
        session.beginTransaction();
        UsersTest u = session.get(UsersTest.class, 1); // persistent state
        session.delete(u); // transient state
        u.setSalary(25000); // since it is intransient state not further modification to object in db
        session.getTransaction().commit();
    }
}
