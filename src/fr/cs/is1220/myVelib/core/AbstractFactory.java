package fr.cs.is1220.myVelib.core;

import java.util.ArrayList;


public abstract class AbstractFactory {
	public abstract Station getStation(ArrayList<Object> props);
	public abstract ParkingSlot getParkingSlot(ArrayList<Object> props);
	public abstract Bicycle getBicycle(ArrayList<Object> props);
	public abstract User getUser(ArrayList<Object> props);
	public abstract Card getCard(ArrayList<Object> props);
}
