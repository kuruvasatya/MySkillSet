package tableperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String ars[]) {

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        fullTimeEmployee.setName("satya");
        fullTimeEmployee.setSalary(12000.0);
        fullTimeEmployee.setBenefits("Transport");

        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setName("Ganesh");
        contractEmployee.setSalary(1100.0);
        contractEmployee.setHoursWorked(40);


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(FullTimeEmployee.class)
                .addAnnotatedClass(ContractEmployee.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(fullTimeEmployee);
        session.save(contractEmployee);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        System.out.println(session.get(FullTimeEmployee.class,1));
        System.out.println(session.get(ContractEmployee.class, 2));
        session.close();
    }
}
