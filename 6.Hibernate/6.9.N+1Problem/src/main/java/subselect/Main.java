package subselect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {

        Customer customer1 = new Customer();
        customer1.setName("satya");

        Customer customer2 = new Customer();
        customer2.setName("ganesh");

        Customer customer3 = new Customer();
        customer3.setName("kuruva");

        Address address1 = new Address(560048, "bangalore");
        address1.setCustomer(customer1);
        Address address2 = new Address(51157, "new york");
        address2.setCustomer(customer1);
        Address address3 = new Address(45785, "San Dieago");
        address3.setCustomer(customer2);
        Address address4 = new Address(7525,  "Santa Clara");
        address3.setCustomer(customer3);

        customer1.setAddress(Arrays.asList(new Address[] {address1, address2}));
        customer2.setAddress(Arrays.asList(new Address[] {address3}));
        customer3.setAddress(Arrays.asList(new Address[] {address4}));

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(customer1);
        session.persist(customer2);
        session.persist(customer3);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        TypedQuery<Customer> query = session.createQuery("from Customer");
        System.out.println("1...........................");
        System.out.println(query.getResultList());
        System.out.println("2..........................");
        session.close();
    }
}
