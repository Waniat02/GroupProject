package Parking;

import Parking.Exception.ParkingException;
import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Vehicle;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    private Map<String, Vehicle> parkedVehicles;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedVehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) throws ParkingException {
        if (parkedVehicles.size() >= capacity) {
            throw new ParkingException("Capacity exceeded!");
        }

        if (parkedVehicles.containsKey(vehicle.getLicensePlate())) {
            throw new ParkingException("Vehicle already parked!");
        }

        parkedVehicles.put(vehicle.getLicensePlate(), vehicle);
        System.out.println(vehicle + " entered at " + vehicle.getEntryTime());
    }

    public void addVehicle(String type, String licensePlate, String state) throws ParkingException {

        if ("car".equalsIgnoreCase(type)) {

            addVehicle(new Car(licensePlate, state));

        } else if ("motorcycle".equalsIgnoreCase(type)) {

            addVehicle(new Motorcycle(licensePlate, state));

        } else {

            throw new ParkingException("Unknown vehicle type.");

        }

    }

    public void showStatus() {
        System.out.println("\n-- Parking Lot Status --");
        System.out.println("Capacity: " + capacity);
        System.out.println("Occupied: " + parkedVehicles.size());

        for (Vehicle v : parkedVehicles.values()) {
            Duration duration = Duration.between(v.getEntryTime(), java.time.LocalDateTime.now());
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;

            System.out.println(v + " | Parked for: " + hours + "h " + minutes + "m");
        }

        System.out.println("-------------------------\n");
    }

    public void removeVehicle(String licensePlate) throws ParkingException {
        Vehicle vehicle = parkedVehicles.remove(licensePlate);

        if (vehicle == null)
            throw new ParkingException("Vehicle does not exist!");

        double fee = vehicle.calculateFee();

        System.out.println(vehicle + " exited. Hours parked: " + vehicle.getHoursParked() + ". Fee: $" + fee);
    }

}
