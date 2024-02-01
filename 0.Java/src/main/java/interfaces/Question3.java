package interfaces;

interface Interface31 {
    public void method();
}

interface Interface32 {
    public default void method() {
        System.out.println("Default method of Interface32");
    }
}

/**
 * Since interface31 has abstract method
 * now we need to provide implementation for it
 */
public class Question3 implements Interface31, Interface32{
    @Override
    public void method() {
        System.out.println("Overriden method");
    }
}
