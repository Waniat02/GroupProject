import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

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

        Vehicle<String> vehicle = parkedVehicles.remove(licensePlate);
        Duration duration = Duration.between(vehicle.getEntryTime(), LocalDateTime.now());
        long minutes = duration.toMinutes();
        double fee = calculateFee(minutes);

        System.out.println("Vehicle " + licensePlate + " exited.");
        System.out.println("Duration: " + minutes + " minutes. Fee: $" + fee);
    }

    private double calculateFee(long minutes) {
        return Math.ceil(minutes / 30.0) * 2.0;
    }

    public void displayStatus() {
        System.out.println("Vehicles Parked: " + parkedVehicles.size() + "/" + capacity);
        parkedVehicles.values().forEach(v ->
                System.out.println("Plate: " + v.getLicensePlate() + ", Type: " + v.getVehicleType()));
    }

    public static void main(String[] args) throws InterruptedException {
        ParkingLotManager lot = new ParkingLotManager(2);
        lot.addVehicle("ABC123", "Car");
        Thread.sleep(2000);
        lot.displayStatus();
        lot.removeVehicle("ABC123");
        lot.displayStatus();
    }
}
