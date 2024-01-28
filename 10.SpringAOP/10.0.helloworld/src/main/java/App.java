public class App {
    public static void main(String args[]) {
        CustomApplicationContext context = new CustomApplicationContext();

        CustomerService customerService = (CustomerService) context.getBean("customerService");
        customerService.printCustomerDetails();
    }
}
