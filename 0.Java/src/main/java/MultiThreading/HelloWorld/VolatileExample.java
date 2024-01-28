package MultiThreading.HelloWorld;

public class VolatileExample {
    private volatile boolean stopFlag = false;

    public void setStopFlag() {
        stopFlag = true;
        System.out.println("Stopping the loop");
    }

    public void run() {
        while(!stopFlag) {
            System.out.println("Thread : " + Thread.currentThread().getName() + " is running");
        }
        System.out.println("Thread : " + Thread.currentThread().getName() + " stopped execution");
    }

    public static void main(String args[]) throws InterruptedException {
        VolatileExample demo = new VolatileExample();
        Thread t1 = new Thread( () -> demo.run());
        Thread t2 = new Thread( () -> demo.setStopFlag());

        t1.start();
        Thread.sleep(1000);
        System.out.println("Thread2 is about to start .......");
        t2.start();
    }
}
