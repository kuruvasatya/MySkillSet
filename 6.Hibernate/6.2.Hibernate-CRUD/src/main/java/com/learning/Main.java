package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // 1. Create
        FullName fullName = new FullName("satya", "ganesh");
        User user = new User(fullName, 1234);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        // 2. Read
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User userRetrieved = session.get(User.class, fullName);
        session.close();
        System.out.println("user from db: "  + userRetrieved);

        // 3. Update
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User userToBeUpdated = session.get(User.class, fullName);
        System.out.println("User object before update " + userToBeUpdated);
        userToBeUpdated.setPhoneNo(98765432);
        // When you update an object in Hibernate, you don't explicitly need to save it again if it's already associated with a Hibernate session.
        // Hibernate automatically tracks changes made to persistent objects,
        // and those changes are synchronized with the database when the transaction is committed.
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Updated user " + session.get(User.class, fullName));
        session.close();

        // 4. delete
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(userToBeUpdated);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("After deleting user " + session.get(User.class, fullName));
        session.close();
    }
}
