package fr.cs.is1220.myVelib.core;

import java.util.ArrayList;

public class BicycleFactory extends AbstractFactory{
	@Override
	public Station getStation(ArrayList<Object> props){
		return null;
	}
	@Override
	public ParkingSlot getParkingSlot(ArrayList<Object> props){
		return null;
	}
	
	@Override
	public Bicycle getBicycle(ArrayList<Object> props){
		if (props == null) {
			return null;
		}
		if (props.size() == 0) {
			System.out.println("Type of bicycle needed");
			return null;
		} else if (props.size() == 1 && BicycleType.contains((String) props.get(0))) {
			//Si un argument de type String qui est contenu dans l'enum BicycleType
			BicycleType bicycleType = BicycleType.valueOf((String) props.get(0));
			return new Bicycle(bicycleType);
		} else {
			System.out.println("Too many arguments in getBicycle");
			return null;
		}
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
