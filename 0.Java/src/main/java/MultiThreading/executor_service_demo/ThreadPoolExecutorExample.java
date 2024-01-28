package MultiThreading.executor_service_demo;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadFactory customThreadFactory = (r) -> {
            Thread t = new Thread(r);
            t.setPriority(Thread.NORM_PRIORITY);
            //t.setName("Custom Thread");
            return t;
        };

        RejectedExecutionHandler customRejectedExecutionHandler = (r, executor) -> {
            System.out.println("Task is rejected " + r.toString());
        };


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                customThreadFactory,
                customRejectedExecutionHandler);

        ArrayList<Runnable> tasks = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Runnable r = () -> {
                System.out.println(">>Thread "  + Thread.currentThread().getName() + " is processing request ..");
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("<< Thread " + Thread.currentThread().getName() + " completed execution." );
            };
            tasks.add(r);
        }

        for(Runnable task: tasks) {
            executor.submit(task);
        }

        executor.shutdown();
    }
}


