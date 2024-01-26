package MultiThreading.HelloWorld;

import java.util.stream.IntStream;

public class ThreadPriorityDemo {
    public void print() {
        IntStream.rangeClosed(1, 10)
                .forEach( num -> {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " " + num + " priority: "+ Thread.currentThread().getPriority() );
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e ) {
//                        // handle exception;
//                    }
                });
    }

    public static void main(String args[]) {
        ThreadPriorityDemo demo = new ThreadPriorityDemo();
        Thread t1 = new Thread(() -> demo.print(), "Low Priority Thread");
        Thread t2 = new Thread(() -> demo.print(), "High Priority Thread");
        Thread t3 = new Thread(() -> demo.print(), "Norm Priority Thread");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
