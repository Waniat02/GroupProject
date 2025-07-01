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
 * @since 2024
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

        while(true) {
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Show Status");
            System.out.println("4. Exit");
            System.out.println("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch(choice) {
                    case 1 -> {
                        // Adding a vehicle
                        System.out.println("Enter Type Of Vehicle ( Car / Motorcycle ): ");
                        String type = scanner.nextLine();
                        System.out.println("Enter License Plate: ");
                        String licensePlate = scanner.nextLine();
                        System.out.println("Enter State ( for example: NY, MD, VA ): ");
                        String state = scanner.nextLine();

                        lot.addVehicle(type, licensePlate, state);
                    }

                    case 2 -> {
                        // Removing a vehicle
                        System.out.println("Enter License Plate: ");
                        String licensePlate = scanner.nextLine();

                        lot.removeVehicle(licensePlate);
                    }

                    case 3 -> {
                        // Check status
                        lot.showStatus();
                    }

                    case 4 -> {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice");

                }
            } catch (ParkingException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    }
}
