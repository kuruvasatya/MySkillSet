package loosecoupling;

public class TestClass {
    public static void main(String args[]) {
        Bus b = new Bus();
        Train t = new Train();

        /**
         * you just need to create a class and pass that as parameter, you dont need to change other classes
         */
        Transport transport = new Transport(b);
        transport.start();
    }
}
