import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String args[]) {
        /**
         * Application context uses eager loading, so all the beans are created
         * as soon as application context is created.
         *
         * whereas if we are using bean factory, beans are created when we call getBean() method
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("vehicle.xml");
        Bus b = (Bus) context.getBean("bus");
        Train t = (Train) context.getBean("train");

        Transport transport = new Transport(b);
        transport.start();
    }
}
