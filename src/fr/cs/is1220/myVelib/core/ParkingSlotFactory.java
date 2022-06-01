package fr.cs.is1220.myVelib.core;

import java.util.ArrayList;

public class ParkingSlotFactory extends AbstractFactory{
	@Override
	public Station getStation(ArrayList<Object> props){
		return null;
	}
	@Override
	public ParkingSlot getParkingSlot(ArrayList<Object> props){
		if (props == null) {
			return null;
		}
		if (props.size()==0) {
			return new ParkingSlot();
		} else if (props.size()==1 && props.get(0) instanceof Bicycle) {
			Bicycle bicycle = (Bicycle) props.get(0);
			return new ParkingSlot(bicycle);
		} else {
			return null;
		}
	}
	@Override
	public Bicycle getBicycle(ArrayList<Object> props){
		return null;
	}
	@Override
	public User getUser(ArrayList<Object> props){
		return null;
	}
	@Override
	public Card getCard(ArrayList<Object> props){
		return null;
	}
}
