package fr.cs.is1220.myVelib.core;

public enum ParkingSlotStatus {
	Occupied, Free, OutOfOrder;
	
	public static boolean contains(String test) {

	    for (ParkingSlotStatus e : ParkingSlotStatus.values()) {
	        if (e.name().equalsIgnoreCase(test)) {
	            return true;
	        }
	    }

	    return false;
	}
}
