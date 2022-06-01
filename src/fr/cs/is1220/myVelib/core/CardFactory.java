package fr.cs.is1220.myVelib.core;

import java.util.ArrayList;

public class CardFactory extends AbstractFactory{
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
		return null;
	}
	@Override
	public Card getCard(ArrayList<Object> props){
		if (props == null) {
			return null;			
		}
		if (props.size() > 0 && props.get(0) instanceof String) {
			String type = (String) props.get(0);
			if(props.size() == 1) {
				if (type.equalsIgnoreCase("Vlibre")) {
					return new VelibreCard();
				} else if (type.equalsIgnoreCase("Vmax")) {
					return new VmaxCard();
				} else {
					return null;
				}
			} else if (props.size() == 2 && props.get(1) instanceof Double) {
				Double timeBalance = (Double) props.get(1);
				if (type.equalsIgnoreCase("Vlibre")) {
					return new VelibreCard(timeBalance);
				} else if (type.equalsIgnoreCase("Vmax")) {
					return new VmaxCard(timeBalance);
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

}
