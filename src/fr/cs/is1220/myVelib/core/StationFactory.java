package fr.cs.is1220.myVelib.core;

import java.util.*;

public class StationFactory extends AbstractFactory {
	
	@Override
	public Station getStation(ArrayList<Object> props) {
		if (props == null) {
			return null;
		} 
		if (props.size() > 0 && StationType.contains((String) props.get(0))) { 		
			//Si le 1e paramètre est bien de type Enum StationType
			StationType stationType = StationType.valueOf((String) props.get(0));
			
			if(props.size() ==1 ) { 			
				//Si c'est l'unique paramètre
				
				return new Station(stationType);
				
			} else if (props.size()>2 && props.get(1) instanceof Double && props.get(2) instanceof Double) { 
				//Si on a des coordonnées GPS
				
				Double x = (Double) props.get(1);
				Double y = (Double) props.get(2);
				
				if(props.size() == 3) {
					//Si seulement 3 arguments
					
					return new Station(x, y, stationType);
					
				} else {
					// On construit les HashMap après création de station, par défaut il sera vide!
					return null;
				}
			}
		}
		return new Station(StationType.valueOf(""));
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
		return null;
	}
}
