public class CustomerServiceProxy extends CustomerService {
    LoggingAspect log = new LoggingAspect();

    @Override
    public void printCustomerDetails() {
        log.log("Before method exectution ");
        super.printCustomerDetails();
        log.log("After method execution");
    }
}
