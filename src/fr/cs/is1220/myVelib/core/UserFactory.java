package fr.cs.is1220.myVelib.core;

import java.util.ArrayList;

public class UserFactory extends AbstractFactory{
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
		return null;
	}
	
	@Override
	public User getUser(ArrayList<Object> props){
		if (props == null) {
			return null;
		}
		if (props.size() > 0 && props.get(0) instanceof String) {
			String name = (String) props.get(0);
			if (props.size() == 1) {
				return new User(name);			
			} else if (props.size()>3 && props.get(1) instanceof Double && props.get(2) instanceof Double) {
				Double x = (Double) props.get(1);
				Double y = (Double) props.get(2);
				if (props.size() == 3) {
					return new User(name,x,y);	
				} else if (props.size() == 4 && props.get(3) instanceof Card) {
					Card card = (Card) props.get(3);
					return new User(name,x,y, card);	
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	@Override
	public Card getCard(ArrayList<Object> props){
		return null;
	}
}
