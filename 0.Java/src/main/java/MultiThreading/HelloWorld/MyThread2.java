package MultiThreading.HelloWorld;

public class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Run method is executed by thread : " + Thread.currentThread().getName());
    }

    public static void main(String args[]) {
        MyThread2 r = new MyThread2();
        Thread t1 = new Thread(r);
        t1.start();
        t1.run();

        Thread t2 = new Thread();
        t2.start();
        t2.run();
    }
}
