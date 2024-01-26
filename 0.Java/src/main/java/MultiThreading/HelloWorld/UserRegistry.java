package MultiThreading.HelloWorld;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserRegistry {
    List<String> activeUsers;
    List<String> oldUsers;

    public UserRegistry() {
        this.activeUsers = IntStream.rangeClosed(1, 50)
            .mapToObj(n -> "user"+n)
            .collect(Collectors.toList());
        Collections.shuffle(this.activeUsers);

        this.oldUsers = IntStream.rangeClosed(51, 100)
                .mapToObj(n -> "user"+n)
                .collect(Collectors.toList());
        Collections.shuffle(this.oldUsers);
    }

    public void search(List<String> records, String user) {
        for(String record: records) {
            System.out.println("Thread :" + Thread.currentThread().getName() + "  has found " + record);
            if(record.equalsIgnoreCase(user)) {
                System.out.println("*********** Thread :" + Thread.currentThread().getName() +" found user...");
                break;
            }
        }
    }


    public static void main(String args[]) {
        UserRegistry registry = new UserRegistry();
        String searchUser= "user" + new Random().nextInt(1, 100);

        System.out.println("Searching for " + searchUser);

        Thread t1 = new Thread(() -> registry.search(registry.activeUsers, searchUser));
        Thread t2 = new Thread(() -> registry.search(registry.oldUsers, searchUser));

        t1.start();
        t2.start();
    }
}
