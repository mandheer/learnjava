package com.learning.problems.vehicleparking;

import com.learning.problems.vehicleparking.model.ParkingSpot;
import com.learning.problems.vehicleparking.model.VehicleType;

import java.util.ArrayList;

public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleType size;

    public int getSpotsNeeded(){
        return spotsNeeded;
    }

    public VehicleType getSize(){
        return size;
    }

    /**
     * Park Vehicle in this spot (among others, potentially)
     */
    public void parkingSpot(ParkingSpot spot){
        parkingSpots.add(spot);
    }

    /**
     * Remove vehicle from spot, and notify spot that it's gone
     */
    public void clearSpots(){

    }

    /**
     * Check if spot is big enough for the vehicle (and is available)
     * This * compares the size only. It doesn't check if it has enough spots
     */
    public abstract boolean canFitInSpot(ParkingSpot spot);

}
