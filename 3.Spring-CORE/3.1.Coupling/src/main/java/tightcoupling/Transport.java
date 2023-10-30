package tightcoupling;

public class Transport {
    /**
     * Here Transport class is tightly coupled with Train, so if you wish to change transport
     * you need to keep changing the file
     */
    public void start() {
        Train t = new Train();
        t.start();
    }
}
