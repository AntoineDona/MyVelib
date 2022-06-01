package fr.cs.is1220.myVelib.core;

public enum StationType {
	Standard,Plus;
	
	public static boolean contains(String test) {

	    for (StationType e : StationType.values()) {
	        if (e.name().equalsIgnoreCase(test)) {
	            return true;
	        }
	    }

	    return false;
	}
}
