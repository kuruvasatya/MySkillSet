import org.hibernate.SQLQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;

import java.util.Random;
import java.util.*;

public class Main {
    public static void setup() {
        Random random = new Random();
        Session session = SessionUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for(int i=1; i <= 10; i++) {
            session.save(new Users("user: " + i, random.nextInt(20000) + 10000));
            System.out.println("saved ");
        }
        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
        setup();

        // 1. print all objects
        Session session = SessionUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Users");
        List<Users> users = query.list();
        session.close();
        System.out.println("size: " + users.size());
        users.stream().forEach(e -> System.out.println(e));

        // 2. where clause
        session = SessionUtil.getSessionFactory().openSession();
        query = session.createQuery("from Users where salary > 25000");
        List<Users> usersWithSalGT = query.list();
        session.close();
        usersWithSalGT.forEach(System.out::println);

        // 3. get unique record
        session = SessionUtil.getSessionFactory().openSession();
        query = session.createQuery("from Users where id = 5");
        Users u = (Users) query.uniqueResult();
        session.close();
        System.out.println("users with id 5: " + u);

        // 4. get salary of user 5
        session = SessionUtil.getSessionFactory().openSession();
        query = session.createQuery("select salary from Users where id = 5");
        long salary = (long) query.uniqueResult();
        session.close();
        System.out.println("salary of user id 5: " + salary);

        // 5. parameterized query
        session = SessionUtil.getSessionFactory().openSession();
        query = session.createQuery("from Users where id= :id");
        query.setParameter("id", 5);
        Users pu = (Users) query.uniqueResult();
        System.out.println("parameterized query result: " + pu);

        // 6. named query
        session = SessionUtil.getSessionFactory().openSession();
        query = session.getNamedQuery("Users.findById");
        query.setParameter("id", 1);
        Users namedQueryResult = (Users) query.uniqueResult();
        System.out.println("Named query result " + namedQueryResult);

        // 6. named native query
        session = SessionUtil.getSessionFactory().openSession();
        query = session.getNamedNativeQuery("Users.nq.findById");
        query.setParameter("id", 1);
        Users namedNativeQueryResult = (Users) query.uniqueResult();
        System.out.println("Named query result " + namedNativeQueryResult);

    }
}
