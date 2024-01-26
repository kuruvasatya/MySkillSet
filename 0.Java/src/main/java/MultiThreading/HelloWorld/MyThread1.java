package MultiThreading.HelloWorld;

public class MyThread1 extends Thread{

    @Override
    public void run() {
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        System.out.println("Current thread in main class 1: " + Thread.currentThread().getName());
        t1.start();
        /**
         * what if we directly call the run method?
         * no new thread will be created, and main thread runs them sequentially
         */
//        t1.run();

        /**
         * what if i call t1.start() twice?
         * it gives illegal thread state exception, we can not reuse the thread.
         */
//        t1.start();
        System.out.println("Current thread in main class 2: " + Thread.currentThread().getName());
    }
}
