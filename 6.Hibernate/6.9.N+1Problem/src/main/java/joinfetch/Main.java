package joinfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .buildSessionFactory();

        Book book1 = new Book();
        book1.setName("C++");
        book1.setAuthor(new Author("John", new Address(8547, "New Jersy")));

        Book book2 = new Book();
        book2.setName("Java");
        book2.setAuthor(new Author("Rebecca", new Address(7547, "Texas")));

        Book book3 = new Book();
        book3.setName("Python");
        book3.setAuthor(new Author("Rachel", new Address(758, "San Fransico")));

        Customer customer1 = new Customer();
        customer1.setName("satya");
        customer1.setBookList(Arrays.asList(new Book[] {book1}));
        book1.setCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setName("ganesh");
        customer2.setBookList(Arrays.asList(new Book[] {book3}));
        book3.setCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setName("kuruva");
        customer3.setBookList(Arrays.asList(new Book[] { book2}));
        book2.setCustomer(customer3);

        Address address1 = new Address();
        address1.setCity("banglore");
        address1.setPincode(560048);
        Address address2 = new Address();
        address2.setCity("NewYork");
        address2.setPincode(1754);
        Address address3 = new Address();
        address3.setPincode(7854);
        address3.setCity("kolkata");

        customer1.setAddress(address1);
        customer2.setAddress(address2);
        customer3.setAddress(address3);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(customer1);
        session.persist(customer2);
        session.persist(customer3);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();

        //use fetch join to get data of related entites
        // JOIN FETCH => inner join
        // LEFT JOIN FETCH => Left join
        TypedQuery<Customer> query = session.createQuery("from Customer c LEFT JOIN FETCH c.address" +
                " LEFT JOIN FETCH c.bookList b LEFT JOIN FETCH b.author c JOIN FETCH c.address");


        System.out.println("1.......................");
        List<Customer> customerList = query.getResultList();
        System.out.println("2..........................");
        for(Customer c: customerList) {
            System.out.println("3..........................");
            System.out.println(c.getAddress().getCity());
            System.out.println("4............................");
            for(Book b: c.getBookList()) {
                System.out.println("5....................");
                System.out.println(b.getAuthor().getName());
                System.out.println("6....................");
            }
        }
        System.out.println(customerList);
        session.getTransaction().commit();
        session.close();
    }
}
