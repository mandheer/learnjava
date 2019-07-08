package com.learning.problems.vehicleparking.model;

public class ParkingSpot {
    private String spotId;
    private VehicleType spotType; //compact/two wheeler/bus/carriage
    private boolean isBooked;

    public ParkingSpot(String spotId,String spotType){
        this.spotId = spotId;
        this.spotType = VehicleType.valueOf(spotType) != null ? VehicleType.valueOf(spotType) : VehicleType.OTHERS ;
        this.isBooked = false;
    }

    public ParkingSpot(String spotId,VehicleType spotType){
        this.spotId = spotId;
        this.spotType = spotType;
        this.isBooked = false;
    }

    public String getSpotId(){
        return spotId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}

