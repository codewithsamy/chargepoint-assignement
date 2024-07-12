package src.main.java;

public class Truck {

	int id;
    int batteryCapacity;
    int currentCharge;

    public Truck(int id, int batteryCapacity, int currentCharge) {
        this.id = id;
        this.batteryCapacity = batteryCapacity;
        this.currentCharge = currentCharge;
    }

    public int remainingCharge() {
        return batteryCapacity - currentCharge;
    }
}
