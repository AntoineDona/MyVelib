package fr.cs.is1220.myVelib.core;

public enum BicycleType {
	Electrical, Mechanical;
	
	public static boolean contains(String test) {

	    for (BicycleType e : BicycleType.values()) {
	        if (e.name().equalsIgnoreCase(test)) {
	            return true;
	        }
	    }

	    return false;
	}
}
