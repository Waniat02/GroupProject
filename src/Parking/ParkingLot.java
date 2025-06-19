package Parking;

import Parking.Exception.ParkingException;
import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Vehicle;

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

}
