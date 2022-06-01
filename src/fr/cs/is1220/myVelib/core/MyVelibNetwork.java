package fr.cs.is1220.myVelib.core;

import java.util.*;

public class MyVelibNetwork {
	private int id;
	private static int idCounter = 1;  
	private String name;
	private Double side;
	private HashMap<Integer,Station> stations = new HashMap<Integer,Station>();
	private HashMap<Integer,User> users = new HashMap<Integer,User>();
	private HashMap<Integer,Bicycle> bicycles = new HashMap<Integer,Bicycle>();
	
	private AbstractFactory stationFactory = new StationFactory();
	private AbstractFactory parkingSlotFactory = new ParkingSlotFactory();
	private AbstractFactory bicycleFactory = new BicycleFactory();
	private AbstractFactory userFactory = new UserFactory();
	private AbstractFactory cardFactory = new CardFactory();

	
	public MyVelibNetwork(String name, Double side) {
		super();
		this.id = idCounter;
		this.name = name;
		this.side = side;
		idCounter++;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSide() {
		return side;
	}
	public void setSide(Double side) {
		this.side = side;
	}
	public HashMap<Integer, Station> getStations() {
		return stations;
	}
	public void setStations(HashMap<Integer, Station> stations) {
		this.stations = stations;
	}
	public HashMap<Integer, User> getUsers() {
		return users;
	}
	public void setUsers(HashMap<Integer, User> users) {
		this.users = users;
	}
	public HashMap<Integer, Bicycle> getBicycles() {
		return bicycles;
	}
	public void setBicycles(HashMap<Integer, Bicycle> bicycles) {
		this.bicycles = bicycles;
	}
	
	
	
	public void addStation(Station station) {
		this.stations.put(station.getId(),station);
	}
	
	public void addMultipleStations(int nbStations, int nbParkingSlots) {
		for (int i = 0; i < nbStations; i++) {
			
			ArrayList<Object> props = new ArrayList<Object>();
			
			HashMap<Integer, ParkingSlot> parkingSlots = new HashMap<Integer, ParkingSlot>() ;
			for(int j = 0; j < nbParkingSlots; j++) {
				ParkingSlot parkingSlot = (ParkingSlot) parkingSlotFactory.getParkingSlot(props);
				parkingSlots.put(parkingSlot.getId(), parkingSlot);
			}
			Random random = new Random();
			
			double x = random.nextDouble()*this.getSide(); // Pour un carr�
			double y = random.nextDouble()*this.getSide();
			double randDouble = random.nextDouble();
			
			props = new ArrayList<Object>();
					
			if(randDouble < 0.5) {props.add("Standard");}
			else {props.add("Plus");}
			
			props.add(x);
			props.add(y);
			props.add(parkingSlots);
			Station station = stationFactory.getStation(props);
			this.stations.put(station.getId(), station);
		}
	}
	
	public void addUser(User user) {
		this.users.put(user.getId(), user);
	}
	
	public void addUser(String name, String CardType) {
		
		Random random = new Random();
		double x = random.nextDouble()*this.getSide();
		double y = random.nextDouble()*this.getSide();
		
		ArrayList<Object> props = new ArrayList<Object>();
		props.add(CardType);
		Card card = cardFactory.getCard(props);
		
		props = new ArrayList<Object>();
		props.add(name);
		props.add(x);
		props.add(y);
		props.add(card);
		
		User user = userFactory.getUser(props);
		this.getUsers().put(user.getId(), user);
		
	}

	
	/*public void offline(Integer stationID) {
		
	}
	
	public void offline(Integer stationID) {
		
	}*/
	
	public void addBicycle(Bicycle bicycle) {
		this.bicycles.put(bicycle.getId(),bicycle);
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
