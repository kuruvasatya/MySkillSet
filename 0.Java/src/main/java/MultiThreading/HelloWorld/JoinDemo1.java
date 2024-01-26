package MultiThreading.HelloWorld;

public class JoinDemo1 {

    public void print() {
        for(int i=0; i< 10; i++) {
            System.out.println(Thread.currentThread().getName() + " i: " + i);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        JoinDemo1 demo = new JoinDemo1();
        Thread t = new Thread(() -> {
            demo.print();
        });
        t.start();
        t.join(); // main Thread waiting for thread t to complete its task
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " i: " + i);
        }
    }
}
