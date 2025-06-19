import Parking.Exception.ParkingException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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


                    }

                    case 2 -> {
                        // Removing a vehicle
                        System.out.println("Enter License Plate: ");
                        String licensePlate = scanner.nextLine();

                    }

                    case 3 -> {
                        // Check status
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
