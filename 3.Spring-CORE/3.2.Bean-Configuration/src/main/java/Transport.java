public class Transport {
    Vehicle vehicle;
    Transport(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void start() {
        this.vehicle.start();
    }

}
