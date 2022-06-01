package fr.cs.is1220.myVelib.core;


public enum StationStatus {
	OnService,Offline;
	
	public static boolean contains(String test) {

	    for (StationStatus e : StationStatus.values()) {
	        if (e.name().equalsIgnoreCase(test)) {
	            return true;
	        }
	    }

	    return false;
	}
	
}
