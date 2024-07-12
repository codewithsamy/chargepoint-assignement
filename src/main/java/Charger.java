package src.main.java;

public class Charger {

	int id;
    int chargingRate;

    public Charger(int id, int chargingRate) {
        this.id = id;
        this.chargingRate = chargingRate;
    }

    public int getChargingTime(Truck truck) {
        int remainingCharge = truck.remainingCharge();
        return (int) Math.ceil((double) remainingCharge / chargingRate);
    }
    
}
