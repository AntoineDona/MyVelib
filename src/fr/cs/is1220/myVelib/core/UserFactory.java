package fr.cs.is1220.myVelib.core;

public class StationFactory {

	public Station getStation(String stationType) {
		if(stationType == null) {
			return null;
		}
		else if(stationType == "standard") {
			return new StandardStation();
		}
		else if(stationType == "plus") {
			return new PlusStation();
		}
	}
}
