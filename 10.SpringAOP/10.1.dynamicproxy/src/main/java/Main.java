import java.lang.reflect.Proxy;

public class Main {
    public static void main(String args[]) {
        CustomerServiceImpl service = new CustomerServiceImpl("Satya");

        CustomerService proxy = (CustomerService) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new ObjectInvocationHandler(service)
        );

        System.out.println(proxy.getCustomerName());
        proxy.updateCustomerName("Ganesh");
        System.out.println(service.getCustomerName());
    }
}
