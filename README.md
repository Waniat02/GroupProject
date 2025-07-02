# Project Title:

Parking Lot Management System


# Project Description

This project is a Java application that simulates a Parking Lot Management System. It will provide basic functionality for tracking vehicles as they enter and exit a parking lot. The system makes sure that the lot does not exceed its capacity, calculates parking fees based on the time each vehicle spends in the lot, and displays the current status of parked vehicles.
The application will use various Java features such as:
- Classes and Objects for modeling the parking lot and vehicles.
- java.time API to accurately compute the duration of parking.
- Conditional logic to handle full capacity and vehicle exit scenarios.

Users will be able to:
- Add (enter) vehicles with a license plate.
- Remove (exit) vehicles and see the fee owed.
- View how many vehicles are currently parked.


# Team Members and Responsibilities

- Project Management:  Wania Tajammal 
- Coders: Jonathan, Madhuri kola
- Support and review members: Raiyan, Mitali, Ayaan

# The Use Of JavaDocs

We used JavaDocs in this project to explain what each class and method does. This helps other people and our team understand the code better.The generated documentation provides a clear structure of the project and can be accessed online through GitHub Pages.

# Java Concepts Implementation

This project demonstrates the use of various Java programming concepts. Below is a comprehensive list of where each **required concept** (marked with *) is implemented with specific file locations and line numbers:

## Required Java Concepts Implementation

### 1. Classes (min 5)*
The project contains the following classes:
- **Main.java** (Line 17) - Main application class with the entry point
- **Vehicle.java** (Line 23) - Abstract base class for all vehicles
- **Car.java** (Line 13) - Concrete class representing cars
- **Motorcycle.java** (Line 13) - Concrete class representing motorcycles
- **ParkingLot.java** (Line 22) - Class managing the parking lot operations
- **ParkingException.java** (Line 14) - Custom exception class for parking errors

### 2. Inheritance*
- **Vehicle Hierarchy**: `Car` (Line 13) and `Motorcycle` (Line 13) classes extend the abstract `Vehicle` class (Line 23)
- **Exception Hierarchy**: `ParkingException` (Line 14) extends the `Exception` class
- **Method Inheritance**: Child classes inherit methods like `getLicensePlate()`, `getState()`, `getEntryTime()` from the parent `Vehicle` class

### 3. Interface*
- **Billable Interface** (`src/Billable/Billable.java` Line 13):
  - Defines the contract for objects that can calculate fees
  - Contains the abstract method `calculateFee()`
  - Implemented by the `Vehicle` class (Line 23)

### 4. Exception*
- **ParkingException** (`src/Parking/Exception/ParkingException.java` Line 14):
  - Custom exception class for parking-related errors
  - Extends the standard `Exception` class
  - Used throughout the application for error handling
  - Thrown when parking lot is full, vehicle not found, or invalid vehicle type

### 5. Method Overriding*
- **calculateFee()**: Overridden in `Vehicle` class (Line 138) to implement the `Billable` interface
- **getRatePerHour()**: Abstract method in `Vehicle` (Line 128), overridden in `Car` (Line 44) and `Motorcycle` (Line 44)
- **toString()**: Overridden in `Vehicle` class (Line 151) to provide custom string representation

### 6. Method Overloading*
- **addVehicle()** in `ParkingLot` class:
  - `addVehicle(Vehicle<?> vehicle)` (Line 50) - accepts a Vehicle object
  - `addVehicle(String type, String licensePlate, String state)` (Line 74) - accepts vehicle details as strings
- **Constructor Overloading** in `Vehicle` class:
  - `Vehicle(String licensePlate, String state)` (Line 43) - basic constructor
  - `Vehicle(String licensePlate, String state, T vehicleType)` (Line 56) - constructor with vehicle type

### 7. Constructor*
- **Vehicle Constructors**: Two constructors (Lines 43, 56) for creating vehicles with or without vehicle type
- **Car Constructors**: Two constructors for creating cars with basic info or specific car type
- **Motorcycle Constructors**: Two constructors for creating motorcycles with basic info or specific motorcycle type
- **ParkingLot Constructor**: Single constructor (Line 37) that initializes capacity and vehicle map
- **ParkingException Constructor**: Constructor (Line 19) that accepts an error message

### 8. Abstraction*
- **Abstract Class**: `Vehicle` (Line 23) is an abstract class that cannot be instantiated directly
- **Abstract Method**: `getRatePerHour()` (Line 128) is an abstract method that must be implemented by subclasses
- **Interface Abstraction**: `Billable` interface (Line 13) provides abstraction for fee calculation

### 9. Generics*
- **Generic Vehicle Class**: `Vehicle<T>` (Line 23) uses generics to allow different types of vehicle characteristics
- **Type Parameter**: `<T>` represents the type of vehicle characteristics or category
- **Generic Methods**: `getVehicleType()` (Line 95) and `setVehicleType(T vehicleType)` (Line 104) work with generic type
- **Wildcard Usage**: `Vehicle<?>` used in `ParkingLot` (Line 28) to handle any vehicle type

### 10. Encapsulation*
- **Private Fields**: All instance variables in classes are private
  - `Vehicle.java` (Lines 26, 29, 32, 35): `licensePlate`, `state`, `entryTime`, `vehicleType`
  - `ParkingLot.java` (Lines 25, 28): `capacity`, `parkedVehicles`
- **Public Methods**: Controlled access to data through public getter and setter methods
- **Data Hiding**: Internal implementation details are hidden from external classes
- **Controlled Access**: Methods like `getLicensePlate()`, `getState()`, `setVehicleType()` provide controlled access to data

### 11. Using Java Library Classes*
- **Scanner** (`java.util.Scanner`): Used in `Main.java` (Line 3) for user input
- **LocalDateTime** (`java.time.LocalDateTime`): Used in `Vehicle.java` (Line 5) for tracking vehicle entry times
- **Duration** (`java.time.Duration`): Used in `Vehicle.java` (Line 4) and `ParkingLot.java` (Line 7) to calculate parking duration
- **HashMap** (`java.util.HashMap`): Used in `ParkingLot.java` (Line 8) to store parked vehicles
- **Map** (`java.util.Map`): Interface used in `ParkingLot.java` (Line 9) for the vehicle collection

### 12. Using Java Collections*
- **HashMap**: `Map<String, Vehicle<?>> parkedVehicles` in `ParkingLot.java` (Line 28)
  - Keys: License plate strings
  - Values: Vehicle objects
  - Used for efficient vehicle lookup and storage
- **Collection Methods**: 
  - `size()` - to check parking lot capacity
  - `containsKey()` - to check if vehicle is already parked
  - `put()` - to add vehicles
  - `remove()` - to remove vehicles
  - `values()` - to iterate through parked vehicles
  - `isEmpty()` - to check if parking lot is empty

## Additional Features

- **Input Validation**: Comprehensive validation for user inputs
- **Error Handling**: Robust exception handling throughout the application
- **User Interface**: Console-based menu system with clear options
- **Documentation**: Complete JavaDoc documentation for all classes and methods
