package MultiThreading.executor_service_demo;

import java.util.concurrent.CompletableFuture;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFuture3 {
    public static void main(String args[]) {
        CompletableFuture3 obj = new CompletableFuture3();
        CompletableFuture<List<String>> dataSource1 = CompletableFuture.supplyAsync(() -> obj.fetchSourceData());
        CompletableFuture<List<String>> dataSource2 = CompletableFuture.supplyAsync(() -> obj.fetchTargetData());

        CompletableFuture<List<String>> dataSource = dataSource1.thenCombine(dataSource2, (source, target) -> {
            List<String> data = new ArrayList<>();
            data.addAll(source);
            data.addAll(target);
            return data;
        });

        CompletableFuture<?> isWhatsAppMessageSent = dataSource.thenAcceptAsync((data) -> {
            System.out.println("Sending data via whatsapp: " + data.toString());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("whatsapp message sent :)");
        });

        CompletableFuture<?> isEmailSent = dataSource.thenAcceptAsync((data) -> {
            System.out.println("Sending data via email: " + data.toString());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("email message sent :)");
        });

        try {
            isEmailSent.get();
            isWhatsAppMessageSent.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public List<String> fetchSourceData() {
        System.out.println("fetching source data source by: " + Thread.currentThread().getName());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> data = IntStream.rangeClosed(1 , 5)
                .mapToObj(num -> "Source" + num)
                .collect(Collectors.toList());
        System.out.println("fetching source data completed....");
        return data;
    }

    public List<String> fetchTargetData() {
        System.out.println("fetching target data source by: " + Thread.currentThread().getName());
        try {
            Thread.sleep(20500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> data = IntStream.rangeClosed(1 , 5)
                .mapToObj(num -> "Target" + num)
                .collect(Collectors.toList());
        System.out.println("fetching target data completed..");
        return data;
    }
}
