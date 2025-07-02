package parking.vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Generic class to represent a vehicle with a license plate and entry time.
 * @param <T> The type of vehicle (e.g., Car, Truck, etc.)
 */
class Vehicle<T> {
    private final String licensePlate;
    private final T vehicleType;
    private final LocalDateTime entryTime;

    public Vehicle(String licensePlate, T vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.entryTime = LocalDateTime.now();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public T getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}

/**
 * Class representing a generic parking lot with a fixed capacity.
 */
public class ParkingLotManager {
    private final int capacity;
    private final Map<String, Vehicle<String>> parkedVehicles;

    public ParkingLotManager(int capacity) {
        this.capacity = capacity;
        this.parkedVehicles = new HashMap<>();
    }

    public void addVehicle(String licensePlate, String vehicleType) {
        if (parkedVehicles.size() >= capacity) {
            System.out.println("Parking Lot Full. Cannot add vehicle: " + licensePlate);
            return;
        }
        if (parkedVehicles.containsKey(licensePlate)) {
            System.out.println("Vehicle already parked.");
            return;
        }

        Vehicle<String> vehicle = new Vehicle<>(licensePlate, vehicleType);
        parkedVehicles.put(licensePlate, vehicle);
        System.out.println("Vehicle " + licensePlate + " parked.");
    }

    public void removeVehicle(String licensePlate) {
        if (!parkedVehicles.containsKey(licensePlate)) {
            System.out.println("Vehicle not found.");
            return;
        }

        parkedVehicles.remove(licensePlate);
        System.out.println("Vehicle " + licensePlate + " exited.");
    }

    public void displayStatus() {
        System.out.println("Vehicles Parked: " + parkedVehicles.size() + "/" + capacity);
        parkedVehicles.values().forEach(v ->
                System.out.println("Plate: " + v.getLicensePlate() + ", Type: " + v.getVehicleType()));
    }

    public static void main(String[] args) {
        ParkingLotManager lot = new ParkingLotManager(2);
        lot.addVehicle("XYZ123", "Car");
        lot.addVehicle("LMN456", "Truck");
        lot.displayStatus();
        lot.removeVehicle("XYZ123");
        lot.displayStatus();
    }
}
