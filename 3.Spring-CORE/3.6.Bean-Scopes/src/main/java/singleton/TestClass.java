package singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String args[]) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("singleton.xml");

        Weather w1 = (Weather)context.getBean("weather");
        Thread.sleep(1000);
        Weather w2 = (Weather) context.getBean("weather");
        System.out.println(w1 + " " + w2);

        ApplicationContext context1 = new ClassPathXmlApplicationContext("prototype.xml");
        Weather w3 = context1.getBean("weather", Weather.class);
        Thread.sleep(1000);
        Weather w4 = context1.getBean("weather", Weather.class);

        System.out.println(w3 + " "+ w4);
    }
}
