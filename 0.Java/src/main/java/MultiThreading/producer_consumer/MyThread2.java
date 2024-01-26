package MultiThreading.producer_consumer;

public class MyThread2 {
    int n = 5;
    String products[] = new String[n];
    int currentSize = 0;


    public synchronized void produce( ) {
        while(currentSize >= n) {
            System.out.println("Currently buffer is full, waiting for consumer to consume.....");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products[currentSize] = "product"+currentSize;
        currentSize++;
        notifyAll();
        System.out.println(products[currentSize-1] + " added to the inventory");
    }

    public synchronized void consume() {
        while (currentSize == 0) {
            System.out.println("Currently there are no elements in buffer, waiting for prooucer to produce...");
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        currentSize--;
        System.out.println(products[currentSize] +" has been consumed");
        notifyAll();
    }

    public static void main(String args[]) {
        MyThread2 res = new MyThread2();
        Thread t1 = new Thread(() -> res.produce());
        Thread t2 = new Thread(() -> res.produce());
        Thread t3 = new Thread(() -> res.produce());
        Thread t4 = new Thread(() -> res.produce());
        Thread t5 = new Thread(() -> res.produce());
        Thread t6 = new Thread(() -> res.produce());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
