public class CustomerServiceImpl implements  CustomerService{
    private String name;

    public CustomerServiceImpl(String name) {
        this.name = name;
    }

    @Override
    public String getCustomerName() {
        return this.name;
    }


    @Override
    public void updateCustomerName(String name) {
        this.name = name;
    }
}
