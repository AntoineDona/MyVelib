package fr.cs.is1220.myVelib.core;

import java.util.*;

import core.ParkingSlot;
import core.Station;


public class MyVelibNetwork {
	private ArrayList<Station> stations;
	private ArrayList<User> users;
	private ArrayList<Bicycle> bicycles;
	private String name;
	
	private static AbstractFactory stationFactory = new StationFactory();
	private static AbstractFactory parkingSlotFactory = new ParkingSlotFactory();
	private static AbstractFactory bicycleFactory = new BicycleFactory();
	private static AbstractFactory userFactory = new UserFactory();
	private static AbstractFactory cardFactory = new CardFactory();
	
	public MyVelibNetwork(String name, ArrayList<Station> stations, ArrayList<User> users, ArrayList<Bicycle> bicycles) {
		super();
		this.name = name;
		this.stations = stations;
		this.users = users;
		this.bicycles = bicycles;
	}
	
	public void addStation(Station station) {
		this.stations.add(station);
	}
	
	public void addStations(int nbStations, int nbParkingSlots) {
		for (int i = 0; i < nbStations; i++) {
			HashMap<Integer, ParkingSlot> parkingSlots = new HashMap<Integer, ParkingSlot>() ;
			for(int j = 0; j < nbParkingSlots; j++) {
				ArrayList<Object> params = new ArrayList<Object>();
				params.add("PARKING");
				ParkingSlot parkingSlot = (ParkingSlot) slotFactory.createSlot(params);
				//ParkingSlot parkingSlot = new ParkingSlot();
				parkingSlots.put(parkingSlot.getID(), parkingSlot);
			}
			Random random = new Random();
			double x = random.nextDouble()*this.getSide(); //Uniformly distributing the stations in the network.
			double y = random.nextDouble()*this.getSide(); //Uniformly distributing the stations in the network.
			double typeOfStation = random.nextDouble();
			//50% chance to be a standard station
			if(typeOfStation >= 0.5) {
				ArrayList<Object> params = new ArrayList<Object>();
				params.add("STANDARD");
				params.add(x);
				params.add(y);
				params.add(parkingSlots);
				Station station = stationFactory.createStation(params);
				//Station station = new StdStation(x, y, parkingSlots);
				this.getStations().put(station.getID(), station);
			}
			else {//50% chance to be a plus station
				ArrayList<Object> params = new ArrayList<Object>();
				params.add("PLUS");
				params.add(x);
				params.add(y);
				params.add(parkingSlots);
				Station station = stationFactory.createStation(params);
				//Station station = new PlusStation(x, y, parkingSlots);
				this.getStations().put(station.getID(), station);
			}
		}
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	// TODO
	public void addUser(User user, String CardType) {
		
	}
	
	public void offline(Integer stationID) {
		
	}
	
	public void offline(Integer stationID) {
		
	}
	
	public void addBicycle(Bicycle bicycle) {
		this.bicycles.add(bicycle);
	}
	
	public void rentBicycle(Integer userID, Integer stationID) {
		// Check si y'a des vélos dispos si y'en a pas : erreur ---> Design pattern observer
		// Si y'en a : slot devient innocupé, user récupère le vélo
	}
	
	public void returnBicycle(Integer userID, Integer stationID, Double duration) {
		// Idem : doit y avoir un slot de libre, alors slot devient occupé, user prélevé
		// Faire appel à TravelCostCalculator, puis le print
	}
	
	public void addMultipleStations
	
	
	
	
}
