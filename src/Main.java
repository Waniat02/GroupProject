import Parking.Exception.ParkingException;
import Parking.ParkingLot;

import java.util.Scanner;

/**
 * Main application class for the Parking Management System.
 * 
 * This class provides a console-based user interface for managing a parking lot.
 * Users can add vehicles (cars or motorcycles), remove vehicles, view parking
 * lot status, and exit the application. The system handles parking exceptions
 * and provides appropriate error messages.
 * 
 * @author Group Project Team
 * @version 1.0
 * @since 2025
 */
public class Main {
    
    /**
     * The main entry point of the parking management application.
     * 
     * This method creates a parking lot with a capacity of 4 vehicles and
     * presents a menu-driven interface for parking operations. The application
     * runs continuously until the user chooses to exit.
     * 
     * @param args command line arguments (not used in this application)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ParkingLot lot = new ParkingLot(4);

        System.out.println("=== Parking Management System ===");
        System.out.println("Welcome to the parking lot management system!");
        System.out.println("Parking lot capacity: " + lot.getCapacity() + " vehicles");

        while(true) {
            try {
                // Display menu
                System.out.println("\n=== MENU ===");
                System.out.println("1. Add Vehicle");
                System.out.println("2. Remove Vehicle");
                System.out.println("3. Show Status");
                System.out.println("4. Exit");
                System.out.print("Choose an option (1-4): ");

                // Handle menu choice input
                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid number (1-4)");
                    continue;
                }

                switch(choice) {
                    case 1 -> {
                        // Adding a vehicle
                        System.out.println("\n=== ADD VEHICLE ===");
                        
                        // Check if parking lot is full
                        if (lot.isFull()) {
                            System.out.println("Error: Parking lot is full! Cannot add more vehicles.");
                            break;
                        }
                        
                        System.out.println("Available spaces: " + lot.getAvailableSpaces());
                        
                        // Get vehicle type with validation
                        System.out.print("Enter Type Of Vehicle (Car/Motorcycle): ");
                        String type = scanner.nextLine().trim();
                        
                        if (type.isEmpty()) {
                            System.out.println("Error: Vehicle type cannot be empty");
                            break;
                        }
                        
                        if (!type.equalsIgnoreCase("car") && !type.equalsIgnoreCase("motorcycle")) {
                            System.out.println("Error: Vehicle type must be 'Car' or 'Motorcycle'");
                            break;
                        }

                        // Get license plate with validation
                        System.out.print("Enter License Plate: ");
                        String licensePlate = scanner.nextLine().trim();
                        
                        if (licensePlate.isEmpty()) {
                            System.out.println("Error: License plate cannot be empty");
                            break;
                        }
                        
                        if (licensePlate.length() < 2) {
                            System.out.println("Error: License plate must be at least 2 characters long");
                            break;
                        }

                        // Get state with validation
                        System.out.print("Enter State (e.g., MD, NY, VA): ");
                        String state = scanner.nextLine().trim();
                        
                        if (state.isEmpty()) {
                            System.out.println("Error: State cannot be empty");
                            break;
                        }
                        
                        if (state.length() != 2) {
                            System.out.println("Error: State must be exactly 2 characters (e.g., NY, MD, VA)");
                            break;
                        }

                        // Add vehicle to parking lot
                        lot.addVehicle(type, licensePlate, state.toUpperCase());
                        System.out.println("Vehicle added successfully!");
                    }

                    case 2 -> {
                        // Removing a vehicle
                        System.out.println("\n=== REMOVE VEHICLE ===");
                        
                        // Check if parking lot is empty
                        if (lot.isEmpty()) {
                            System.out.println("Parking lot is empty. No vehicles to remove.");
                            break;
                        }
                        
                        System.out.println("Currently parked vehicles: " + lot.getOccupiedSpaces());
                        
                        // Show list of parked vehicles (license plate and state only)
                        System.out.println("\n--- Parked Vehicles ---");
                        lot.listVehicles();
                        
                        System.out.print("Enter License Plate: ");
                        String licensePlate = scanner.nextLine().trim();
                        
                        if (licensePlate.isEmpty()) {
                            System.out.println("Error: License plate cannot be empty");
                            break;
                        }

                        lot.removeVehicle(licensePlate);
                        System.out.println("Vehicle removed successfully!");
                    }

                    case 3 -> {
                        // Check status
                        System.out.println("\n=== PARKING LOT STATUS ===");
                        lot.showStatus();
                    }

                    case 4 -> {
                        // Exit application
                        System.out.println("\nThank you for using the Parking Management System!");
                        System.out.println("Goodbye!");
                        scanner.close();
                        System.exit(0);
                    }
                    
                    default -> {
                        System.out.println("Error: Please enter a valid choice (1-4)");
                    }
                }
                
            } catch (ParkingException e) {
                System.out.println("Parking Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }
}
