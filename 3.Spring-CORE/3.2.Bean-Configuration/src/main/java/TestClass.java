import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("vehicle.xml");
        Bus b = (Bus) context.getBean("bus");
        Train t = (Train) context.getBean("train");

        Transport transport = new Transport(b);
        transport.start();
    }
}
