package fr.cs.is1220.myVelib.core;

public class StationFactory {

	public Station getStation(StationType stationType) {
		if(stationType == null) {
			return null;
		}
		else if(stationType.valueOf("Standard")) {
			return new StandardStation();
		}
		else if(stationType.valueOf("Plus")) {
			return new PlusStation();
		}
	}
}