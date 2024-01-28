package MultiThreading.executor_service_demo;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture1 {
    public static void main(String[] args) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future 1: supplyAsync -> Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        }).thenApply(x -> {
            System.out.println("future 1: theApply1 -> Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x + 1;
        }).thenApply(x -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future 1: theApply2 -> Thread: " + Thread.currentThread().getName());
            return x + 1;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future 2: supplyAsync -> Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        }).thenApply(x -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future 2: theApply1 -> Thread: " + Thread.currentThread().getName());
            return x + 1;
        }).thenApply(x -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future 2: theApply2 -> Thread: " + Thread.currentThread().getName());
            return x + 1;
        });

        try {
            future1.get();
            future2.get();
        } catch (Exception e) {

        }
    }
}
