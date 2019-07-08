package com.learning.problems.vehicleparking.model;

public enum VehicleType {
    BICYCLE("bicycle"),
    MOTORCYCLE("motorbike"),
    COMPACT_VEHICLE("compactCar"),
    NORMAL_VEHICLE("normalCar"),
    LARGE_VEHICLE("extraLargeVehicles"),
    OTHERS("aeroPlane");

    private String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

}
