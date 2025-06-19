package Vehicles;

import Billable.Billable;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Vehicle implements Billable {

    private String licensePlate;
    private String state;
    private LocalDateTime entryTime;

    public Vehicle(String licensePlate, String state) {
        this.licensePlate = licensePlate;
        this.state = state;
        this.entryTime = LocalDateTime.now();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getState() {
        return state;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public long getHoursParked() {
        return Duration.between(entryTime, LocalDateTime.now()).toHours() + 1;
    }

    public abstract double getRatePerHour();

    @Override
    public double calculateFee() {
        return getHoursParked() * getRatePerHour();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [licensePlate=" + licensePlate + ", state=" + state + ", entryTime=" + entryTime + "]";
    }

}
