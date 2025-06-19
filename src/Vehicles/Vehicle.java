package Vehicles;

import Billable.Billable;


public abstract class Vehicle implements Billable {

    private String licensePlate;
    private String state;

    public Vehicle(String licensePlate, String state) {
        this.licensePlate = licensePlate;
        this.state = state;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getState() {
        return state;
    }



}
