package MultiThreading.producer_consumer;

public class MyThread1 {
    int itemsAvailable = 0;

    public synchronized void produce() {
        itemsAvailable++;
        System.out.println("Total items available: " + itemsAvailable);
        notifyAll();
    }

    public synchronized void consume() {
        while (itemsAvailable == 0) {
            System.out.println("No resource available at this point of time ..");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        itemsAvailable--;
        System.out.println("items available after consumption: " + itemsAvailable);
    }

    public static void main(String args[]) {
        MyThread1 res = new MyThread1();
        Thread t1 = new Thread(() -> res.consume());
        Thread t2 = new Thread(() -> res.produce());
        Thread t3 = new Thread(() -> res.consume());
        Thread t4 = new Thread(() -> res.produce());
        Thread t5 = new Thread(() -> res.produce());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
