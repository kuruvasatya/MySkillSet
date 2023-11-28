package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String args[]) {

        FullName fname = new FullName("Satya", "Ganesh","kuruva");
        UserDetails userDetails = new UserDetails(fname, 918201137, "male", "I am a programmer");

        Configuration cnfg = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserDetails.class);
        SessionFactory factory = cnfg.buildSessionFactory();

        Session session= factory.getCurrentSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
    }
}
