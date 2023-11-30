import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Address current = new Address("bangalore", 560048);
        Address permanent = new Address("New York", 56215);
        UserDetails userDetails = new UserDetails(9, new HashSet<>(Arrays.asList(new Address[] {current, permanent})));

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(UserDetails.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        System.out.println("Inserted object: " + session.get(UserDetails.class, 1));
        session.close();
    }
}
