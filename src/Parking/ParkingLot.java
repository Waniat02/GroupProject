package Parking;

import Parking.Exception.ParkingException;
import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Vehicle;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a parking lot that manages vehicle entry, exit, and fee calculation.
 * 
 * This class provides functionality to add and remove vehicles from the parking lot,
 * track parking status, and calculate fees based on vehicle type and parking duration.
 * The parking lot has a fixed capacity and prevents duplicate vehicle entries.
 * 
 * @author Group Project Team
 * @version 1.0
 * @since 2025
 */
public class ParkingLot {

    /** The maximum number of vehicles that can be parked in the lot */
    private int capacity;
    
    /** Map of currently parked vehicles, keyed by license plate */
    private Map<String, Vehicle<?>> parkedVehicles;

    /**
     * Constructs a new ParkingLot with the specified capacity.
     * 
     * @param capacity the maximum number of vehicles that can be parked
     */
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedVehicles = new HashMap<>();
    }

    /**
     * Adds a vehicle to the parking lot.
     * 
     * This method checks if the parking lot has available capacity and if the
     * vehicle is not already parked. If both conditions are met, the vehicle
     * is added to the parking lot and its entry time is recorded.
     * 
     * @param vehicle the vehicle to add to the parking lot
     * @throws ParkingException if the parking lot is at capacity or the vehicle is already parked
     */
    public void addVehicle(Vehicle<?> vehicle) throws ParkingException {
        if (parkedVehicles.size() >= capacity) {
            throw new ParkingException("Capacity exceeded!");
        }

        if (parkedVehicles.containsKey(vehicle.getLicensePlate())) {
            throw new ParkingException("Vehicle already parked!");
        }

        parkedVehicles.put(vehicle.getLicensePlate(), vehicle);
        System.out.println(vehicle + " entered at " + vehicle.getEntryTime());
    }

    /**
     * Adds a vehicle to the parking lot by creating it from type and details.
     * 
     * This method creates a vehicle object based on the specified type (car or motorcycle)
     * and then adds it to the parking lot using the addVehicle(Vehicle) method.
     * 
     * @param type the type of vehicle ("car" or "motorcycle", case-insensitive)
     * @param licensePlate the vehicle's license plate number
     * @param state the state where the vehicle is registered
     * @throws ParkingException if the vehicle type is unknown or if parking fails
     */
    public void addVehicle(String type, String licensePlate, String state) throws ParkingException {

        if ("car".equalsIgnoreCase(type)) {

            addVehicle(new Car(licensePlate, state));

        } else if ("motorcycle".equalsIgnoreCase(type)) {

            addVehicle(new Motorcycle(licensePlate, state));

        } else {

            throw new ParkingException("Unknown vehicle type.");

        }

    }

    /**
     * Displays the current status of the parking lot.
     * 
     * This method shows the parking lot's capacity, current occupancy, and
     * details about each parked vehicle including how long it has been parked.
     */
    public void showStatus() {
        System.out.println("\n-- Parking Lot Status --");
        System.out.println("Capacity: " + capacity);
        System.out.println("Occupied: " + parkedVehicles.size());

        for (Vehicle<?> v : parkedVehicles.values()) {
            Duration duration = Duration.between(v.getEntryTime(), java.time.LocalDateTime.now());
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;

            System.out.println(v + " | Parked for: " + hours + "h " + minutes + "m");
        }

        System.out.println("-------------------------\n");
    }

    /**
     * Removes a vehicle from the parking lot and calculates the parking fee.
     * 
     * This method removes the vehicle with the specified license plate from
     * the parking lot and calculates the parking fee based on the vehicle's
     * hourly rate and parking duration.
     * 
     * @param licensePlate the license plate of the vehicle to remove
     * @throws ParkingException if the vehicle is not found in the parking lot
     */
    public void removeVehicle(String licensePlate) throws ParkingException {
        Vehicle<?> vehicle = parkedVehicles.remove(licensePlate);

        if (vehicle == null)
            throw new ParkingException("Vehicle does not exist!");

        double fee = vehicle.calculateFee();

        System.out.println(vehicle + " exited. Hours parked: " + vehicle.getHoursParked() + ". Fee: $" + fee);
    }

    /**
     * Gets the number of currently occupied parking spaces.
     * 
     * @return the number of vehicles currently parked in the lot
     */
    public int getOccupiedSpaces() {
        return parkedVehicles.size();
    }

    /**
     * Gets the total capacity of the parking lot.
     * 
     * @return the maximum number of vehicles that can be parked
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Checks if the parking lot is at full capacity.
     * 
     * @return true if the parking lot is full, false otherwise
     */
    public boolean isFull() {
        return parkedVehicles.size() >= capacity;
    }

    /**
     * Checks if the parking lot is empty.
     * 
     * @return true if no vehicles are parked, false otherwise
     */
    public boolean isEmpty() {
        return parkedVehicles.isEmpty();
    }

    /**
     * Gets the number of available parking spaces.
     * 
     * @return the number of empty parking spaces
     */
    public int getAvailableSpaces() {
        return capacity - parkedVehicles.size();
    }

    /**
     * Lists all parked vehicles showing license plate, state, and vehicle type.
     * 
     * This method provides a concise list of vehicles for selection purposes,
     * showing the essential information needed to identify vehicles including
     * their type (Car or Motorcycle).
     */
    public void listVehicles() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles currently parked.");
            return;
        }
        
        int count = 1;
        for (Vehicle<?> vehicle : parkedVehicles.values()) {
            System.out.println(count + ". " + vehicle.getClass().getSimpleName() + 
                             " | License Plate: " + vehicle.getLicensePlate() + 
                             " | State: " + vehicle.getState());
            count++;
        }
    }

}
