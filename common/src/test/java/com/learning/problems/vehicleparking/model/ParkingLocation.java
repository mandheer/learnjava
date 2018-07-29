package com.learning.problems.vehicleparking.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLocation {
    private String LocationId;
    private String locationAddress;
    private String postcode;
    private List<ParkingZone> parkingZones;

    public ParkingLocation() {
        parkingZones = new ArrayList<>();
    }

    public ParkingLocation(String locationId, String locationAddress, String postcode) {
        this.LocationId = locationId;
        this.locationAddress = locationAddress;
        this.postcode = postcode;
        this.parkingZones = new ArrayList<>();
        }

    public String getLocationId() {
        return LocationId;
    }

    public void setLocationId(String locationId) {
        LocationId = locationId;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public List<ParkingZone> getParkingZones() {
        return parkingZones;
    }

    public void setParkingZones(List<ParkingZone> parkingZones) {
        this.parkingZones = parkingZones;
    }

    public void addparkingZone(ParkingZone parkingZone){
        this.parkingZones.add(parkingZone);
    }
}
