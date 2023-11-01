package usingannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");

        //to close the applcation context
        ((ClassPathXmlApplicationContext)context).registerShutdownHook();

        /**
         * I am constructor
         * i am injecting the dependency..
         * init method ...
         * destroy method ...
         */
    }
}
