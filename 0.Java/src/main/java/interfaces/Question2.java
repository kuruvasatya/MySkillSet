package interfaces;

interface Interface21 {
    public default void method() {
        System.out.println("Default method of Interface A");
    }
}

interface Interface22 {
    public default void method() {
        System.out.println("Default method of Interface B");
    }
}

/**
 * since both interfaces has same method signatures,
 * now its developer responsibility to override the default
 * method in implementation class
 */
public class Question2 implements Interface21, Interface22 {

    @Override
    public void method() {
        Interface21.super.method();
        Interface22.super.method();
    }
}
