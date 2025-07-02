package Vehicles;

import Billable.Billable;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Abstract base class for all vehicles in the parking system.
 * 
 * This class provides common functionality for all vehicle types including
 * license plate management, state registration, entry time tracking, and
 * fee calculation. It implements the Billable interface to support parking
 * fee calculations based on hourly rates and parking duration.
 * 
 * The class uses generics to allow for different vehicle characteristics
 * or categories to be specified at runtime.
 * 
 * @param <T> the type representing vehicle characteristics or category
 * @author Group Project Team
 * @version 1.0
 * @since 2025
 */
public abstract class Vehicle<T> implements Billable {

    /** The vehicle's license plate number */
    private String licensePlate;
    
    /** The state where the vehicle is registered */
    private String state;
    
    /** The timestamp when the vehicle entered the parking lot */
    private LocalDateTime entryTime;
    
    /** The vehicle's characteristics or category */
    private T vehicleType;

    /**
     * Constructs a new Vehicle with the specified license plate and state.
     * 
     * @param licensePlate the vehicle's license plate number
     * @param state the state where the vehicle is registered
     */
    public Vehicle(String licensePlate, String state) {
        this.licensePlate = licensePlate;
        this.state = state;
        this.entryTime = LocalDateTime.now();
    }

    /**
     * Constructs a new Vehicle with the specified license plate, state, and vehicle type.
     * 
     * @param licensePlate the vehicle's license plate number
     * @param state the state where the vehicle is registered
     * @param vehicleType the vehicle's characteristics or category
     */
    public Vehicle(String licensePlate, String state, T vehicleType) {
        this.licensePlate = licensePlate;
        this.state = state;
        this.entryTime = LocalDateTime.now();
        this.vehicleType = vehicleType;
    }

    /**
     * Gets the vehicle's license plate number.
     * 
     * @return the license plate number as a String
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Gets the state where the vehicle is registered.
     * 
     * @return the state registration as a String
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the timestamp when the vehicle entered the parking lot.
     * 
     * @return the entry time as a LocalDateTime object
     */
    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    /**
     * Gets the vehicle's characteristics or category.
     * 
     * @return the vehicle type as T
     */
    public T getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets the vehicle's characteristics or category.
     * 
     * @param vehicleType the vehicle type to set
     */
    public void setVehicleType(T vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * Calculates the number of hours the vehicle has been parked.
     * 
     * This method calculates the duration between the entry time and the current
     * time, then adds 1 hour to ensure minimum billing (even for partial hours).
     * 
     * @return the number of hours parked as a long value
     */
    public long getHoursParked() {
        return Duration.between(entryTime, LocalDateTime.now()).toHours() + 1;
    }

    /**
     * Gets the hourly parking rate for this vehicle type.
     * 
     * This abstract method must be implemented by concrete vehicle classes
     * to specify their specific hourly parking rates.
     * 
     * @return the hourly rate as a double value
     */
    public abstract double getRatePerHour();

    /**
     * Calculates the total parking fee for this vehicle.
     * 
     * The fee is calculated by multiplying the number of hours parked by
     * the vehicle's hourly rate. This method implements the Billable interface.
     * 
     * @return the calculated parking fee as a double value
     */
    @Override
    public double calculateFee() {
        return getHoursParked() * getRatePerHour();
    }

    /**
     * Returns a string representation of the vehicle.
     * 
     * The string includes the vehicle type, license plate, state, entry time,
     * and vehicle characteristics if available.
     * 
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        String baseInfo = this.getClass().getSimpleName() + " [licensePlate=" + licensePlate + 
                         ", state=" + state + ", entryTime=" + entryTime;
        
        if (vehicleType != null) {
            return baseInfo + ", vehicleType=" + vehicleType + "]";
        } else {
            return baseInfo + "]";
        }
    }

}
