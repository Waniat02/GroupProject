package Parking.Exception;

/**
 * Custom exception class for parking-related errors.
 * 
 * This exception is thrown when parking operations encounter errors such as
 * capacity exceeded, vehicle not found, or invalid vehicle types. It extends
 * the standard Exception class to provide specific error handling for the
 * parking system.
 * 
 * @author Group Project Team
 * @version 1.0
 * @since 2025
 */
public class ParkingException extends Exception {
    
    /**
     * Constructs a new ParkingException with the specified detail message.
     * 
     * @param message the detail message explaining the parking error
     */
    public ParkingException(String message) {
        super(message);
    }
}
