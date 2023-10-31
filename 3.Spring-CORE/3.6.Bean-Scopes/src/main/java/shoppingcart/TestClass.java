package shoppingcart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("cart.xml");
        Cart user1 = context.getBean("cart", Cart.class);
        user1.addProduct(context.getBean("laptop", Product.class));
        user1.addProduct(context.getBean("bicycle", Product.class));

        System.out.println("printing cart1 .....");
        user1.printCart();

        Cart user2 = context.getBean("cart", Cart.class);
        user2.addProduct(context.getBean("iphone", Product.class));

        System.out.println("printing cart2 ...");
        user2.printCart();
    }
}
