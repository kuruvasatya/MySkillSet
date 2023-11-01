import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Cricket cricket = context.getBean("cricket", Cricket.class);
        System.out.println(cricket);

    }
}
