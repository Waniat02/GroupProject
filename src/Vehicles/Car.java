package Vehicles;

public class Car extends Vehicle {
    public Car(String licensePlate, String state) {
        super(licensePlate, state);
    }

    @Override
    public double getRatePerHour() {
        return 2.5;
    }
}
