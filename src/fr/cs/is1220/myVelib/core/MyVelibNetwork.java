package fr.cs.is1220.myVelib.core;

import java.util.*;


public class MyVelibNetwork {
	private ArrayList<Station> stations;
	private ArrayList<User> users;
	private ArrayList<Bicycle> bicycles;
	
	private static AbstractFactory stationFactory = new StationFactory();
	private static AbstractFactory parkingSlotFactory = new ParkingSlotFactory();
	private static AbstractFactory userFactory = new UserFactory();
	private static AbstractFactory cardFactory = new CardFactory();
	private static AbstractFactory bicycleFactory = new BicycleFactory();
	
	public MyVelibNetwork(ArrayList<Station> stations, ArrayList<User> users, ArrayList<Bicycle> bicycles) {
		super();
		this.stations = stations;
		this.users = users;
		this.bicycles = bicycles;
	}
	
	public void addStation(Station station) {
		this.stations.add(station);
	}
	
	public void addUser(User user) {
		this.users.add(user);
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
	
	
	
}
