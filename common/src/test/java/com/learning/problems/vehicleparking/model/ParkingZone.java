package com.learning.problems.vehicleparking.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingZone {
    private String zoneId;
    private String zoneName;
    private String zoneRefLocation;
    private String zoneLevel;
    private List<ParkingSpot> parkingSpots;

    public ParkingZone() {
        parkingSpots = new ArrayList<>();
    }

    public ParkingZone(String zoneId, String zoneName, String zoneRefLocation, String zoneLevel, List<ParkingSpot> parkingSpots) {
        this.zoneId = zoneId;
        this.zoneName = zoneName;
        this.zoneRefLocation = zoneRefLocation;
        this.zoneLevel = zoneLevel;
        this.parkingSpots = parkingSpots;
    }


    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getZoneRefLocation() {
        return zoneRefLocation;
    }

    public void setZoneRefLocation(String zoneRefLocation) {
        this.zoneRefLocation = zoneRefLocation;
    }

    public String getZoneLevel() {
        return zoneLevel;
    }

    public void setZoneLevel(String zoneLevel) {
        this.zoneLevel = zoneLevel;
    }
}
