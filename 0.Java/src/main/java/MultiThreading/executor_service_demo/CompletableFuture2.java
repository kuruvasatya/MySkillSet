package MultiThreading.executor_service_demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture2 {
    public static void main(String args[]) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future1 -> Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        });

        CompletableFuture<Integer> future2 = future1.thenApplyAsync((x) -> {
            System.out.println("Sending email confirmation " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x + 1;
        });

        CompletableFuture<Integer> future3 = future1.thenApplyAsync((x) -> {
            System.out.println("Sending whatsapp confirmation " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x + 1;
        });


        try {
            future2.get();
            future3.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
