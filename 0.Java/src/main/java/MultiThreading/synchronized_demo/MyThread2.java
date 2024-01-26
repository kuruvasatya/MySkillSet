package MultiThreading.synchronized_demo;

public class MyThread2 {
    public synchronized void wish(String name) {
        for(int i=0; i < 5; i++) {
            System.out.println(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String ...args) {
        MyThread2 x = new MyThread2();
        MyThread2 y = new MyThread2();
        Thread t1 = new Thread(() -> x.wish("Dhoni"));
        Thread t2 = new Thread(() -> y.wish("Raina"));

        t1.start();
        t2.start();
    }
}
