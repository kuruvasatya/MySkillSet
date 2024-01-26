package MultiThreading.HelloWorld;

public class YieldDemo {
    public void print() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Child Thread " + i);
            Thread.yield();
            try {
                // Sleep to simulate some work
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        YieldDemo demo = new YieldDemo();
        Thread t1 = new Thread(() -> demo.print());
        t1.start();
        for(int i = 0; i < 10; i++) {
            System.out.println("Main Thread " + i);
        }
    }
}
