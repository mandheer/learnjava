package com.learning.problems.vehicleparking;

import com.learning.problems.vehicleparking.model.ParkingLocation;
import com.learning.problems.vehicleparking.model.ParkingSpot;
import com.learning.problems.vehicleparking.model.ParkingZone;
import com.learning.problems.vehicleparking.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingHub {
    public static void main(String[] args) {
        ParkingLocation location = createDatabase();





    }

    private static ParkingLocation createDatabase(){
        ParkingLocation cityCenter = new ParkingLocation();
        cityCenter.setLocationId("City Center Mall Parking");
        cityCenter.setLocationAddress("");
        cityCenter.setPostcode("110061");
        cityCenter.setParkingZones(createParkingZones());
        return cityCenter;
    }

    private static List<ParkingZone> createParkingZones(){
        List<ParkingZone> parkingZones = new ArrayList<>();
        for(int i = 1; i <10; i++){
            String str = Integer.toString(i);
            parkingZones.add(createParkingZone("ZONE_"+str,"Tornado_"+str,"SouthEast","Ground"));
        }
        return parkingZones;
    }

    private static ParkingZone createParkingZone(String zId,String zName,String refLoc,String lvl){
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.addAll(createParkingSpots(1450,1459,VehicleType.MOTORCYCLE));
        parkingSpots.addAll(createParkingSpots(1460,1469,VehicleType.NORMAL_VEHICLE));
        parkingSpots.addAll(createParkingSpots(1470,1479,VehicleType.COMPACT_VEHICLE));
        ParkingZone pz = new ParkingZone(zId,zName,refLoc,lvl,parkingSpots);
        return pz;

    }

    private static List<ParkingSpot> createParkingSpots(int stRange, int endRange, VehicleType type){
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (int i = stRange;i<=endRange; i++){
            parkingSpots.add(new ParkingSpot(Integer.toString(i),type));
        }
        return parkingSpots;
    }
}
