package Vehicles;

/**
 * Represents a motorcycle in the parking system.
 * 
 * This class extends the Vehicle abstract class and provides specific
 * functionality for motorcycles. Motorcycles have a lower hourly parking
 * rate compared to cars, reflecting their smaller size and space requirements.
 * 
 * @author Group Project Team
 * @version 1.0
 * @since 2025
 */
public class Motorcycle extends Vehicle<String> {
    
    /**
     * Constructs a new Motorcycle with the specified license plate and state.
     * 
     * @param licensePlate the motorcycle's license plate number
     * @param state the state where the motorcycle is registered
     */
    public Motorcycle(String licensePlate, String state) {
        super(licensePlate, state);
    }

    /**
     * Constructs a new Motorcycle with the specified license plate, state, and motorcycle type.
     * 
     * @param licensePlate the motorcycle's license plate number
     * @param state the state where the motorcycle is registered
     * @param motorcycleType the specific type of motorcycle (e.g., "Sport", "Cruiser", "Touring")
     */
    public Motorcycle(String licensePlate, String state, String motorcycleType) {
        super(licensePlate, state, motorcycleType);
    }

    /**
     * Gets the hourly parking rate for motorcycles.
     * 
     * Motorcycles have a lower hourly rate ($1.50) compared to cars
     * due to their smaller size and space requirements.
     * 
     * @return the hourly rate for motorcycles as a double value (1.5)
     */
    @Override
    public double getRatePerHour() {
        return 1.5;
    }
}
