package Billable;

/**
 * Interface for objects that can calculate billing fees.
 * 
 * This interface defines a contract for any object that needs to calculate
 * a fee or cost. It is implemented by vehicle classes to determine parking fees
 * based on their specific rates and parking duration.
 * 
 * @author Group Project Team
 * @version 1.0
 * @since 2024
 */
public interface Billable {
    
    /**
     * Calculates the fee for the billable object.
     * 
     * This method should return the total fee calculated based on the
     * object's specific billing logic (e.g., hourly rate, duration, etc.).
     * 
     * @return the calculated fee as a double value
     */
    double calculateFee();
}
