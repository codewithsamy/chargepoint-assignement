package src.main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FleetScheduling {

    public static Map<Integer, List<Integer>> scheduleCharging(List<Truck> trucks, List<Charger> chargers, int hours) {
        Map<Integer, List<Integer>> schedule = new HashMap<>();

        trucks.sort((t1, t2) -> Integer.compare(t2.remainingCharge(), t1.remainingCharge()));

        for (Truck truck : trucks) {
            Charger bestCharger = null;
            int bestTime = Integer.MAX_VALUE;

            //find charger that can charge the truck in the least amount of time
            for (Charger charger : chargers) {
                int chargeTime = charger.getChargingTime(truck);
                if (chargeTime <= hours && chargeTime < bestTime) {
                    bestCharger = charger;
                    bestTime = chargeTime;
                }
            }

            //if a charger is found, schedule the truck on that charger
            if (bestCharger != null) {
                schedule.putIfAbsent(bestCharger.id, new ArrayList<>());
                schedule.get(bestCharger.id).add(truck.id);
                hours -= bestCharger.getChargingTime(truck);
                truck.currentCharge = truck.batteryCapacity;
            }
        }

        return schedule;
    }

    public static void main(String[] args) {
        List<Truck> trucks = new ArrayList<>();
        trucks.add(new Truck(1, 100, 50));
        trucks.add(new Truck(2, 150, 75));
        trucks.add(new Truck(3, 120, 60));
        trucks.add(new Truck(4, 200, 100));

        List<Charger> chargers = new ArrayList<>();
        chargers.add(new Charger(1, 50));
        chargers.add(new Charger(2, 75));

        int hours = 8;

        Map<Integer, List<Integer>> schedule = scheduleCharging(trucks, chargers, hours);

        //printing the schedule
        for (Map.Entry<Integer, List<Integer>> entry : schedule.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (int truckId : entry.getValue()) {
                System.out.print(truckId + " ");
            }
            System.out.println();
        }
    }
    
}
