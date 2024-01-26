package MultiThreading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrantlock_demo {
    static ReentrantLock lock = new ReentrantLock();

    public void wish(String s) {
        lock.lock();
        for(int i = 0; i < 10; i++) {
            System.out.print("Good Morning : " );
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            System.out.println(s);
        }
        lock.unlock();
    }
    public static void main(String args[]) {
        Reentrantlock_demo demo = new Reentrantlock_demo();
        Reentrantlock_demo demo1 = new Reentrantlock_demo();

        Thread t1 = new Thread(() -> demo.wish("Satya"));
        Thread t2 = new Thread(() -> demo1.wish("Ganesh"));

        t1.start();
        t2.start();
    }
}
