public class CustomApplicationContext {
    public Object getBean(String beanName) {
        if("customerService".equalsIgnoreCase(beanName)) {
            return new CustomerServiceProxy();
        } else {
            return new OrderService();
        }
    }
}
