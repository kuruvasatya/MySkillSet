public class Bus implements Vehicle {
    /**
     * Note: if class do not have default constructor then, spring would throw
     * BeanInstantiationException, as Sping use reflection API to create object of class
     * and reflection api uses default constructor to create object
     */
    Bus() {
        System.out.println("Bus class loaded");
    }
    public void start() {
        System.out.println("Bus is starting ... ");
    }
}
