package MultiThreading.HelloWorld;

public class JoinDemo2 {
    public void print() {
        for(int i=0; i< 10; i++) {
            System.out.println(Thread.currentThread().getName() + " i: " + i);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        JoinDemo2 demo = new JoinDemo2();
        Thread currentThread  = Thread.currentThread();
        Thread t = new Thread(() -> {
            try {
                currentThread.join();
            } catch (InterruptedException e) {

            }
            demo.print();
        });
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " i: " + i);
        }
    }
}
