package fr.cs.is1220.myVelib.core;



public class User {
	private static Integer idCounter = 1;
	private Integer id;
	private String name;
	private Double x;
	private Double y;
	private Card card;
	private Bicycle rentedBicycle;

	
	private Integer nbRentals;
	private Double totalCharge;
	private Double totalTime;
	private Double creditEarned;
	
	
	public User(String name, Double x, Double y, Card card) {
		super();
		this.id = idCounter;
		this.name = name;
		this.x = x;
		this.y = y;
		this.card = card;
		idCounter ++;
		
		this.nbRentals = 0;
		this.totalCharge = 0.;
		this.totalTime = 0.;
		this.creditEarned = 0.;
	}
	
	
	public User(String name, Double x, Double y) {
		super();
		this.id = idCounter;
		this.name = name;
		this.x = x;
		this.y = y;
		idCounter ++;
		
		this.nbRentals = 0;
		this.totalCharge = 0.;
		this.totalTime = 0.;
		this.creditEarned = 0.;
	}


	public User(String name) {
		super();
		this.id = idCounter;
		this.name = name;
		idCounter ++;
		
		this.nbRentals = 0;
		this.totalCharge = 0.;
		this.totalTime = 0.;
		this.creditEarned = 0.;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getX() {
		return x;
	}


	public void setX(Double x) {
		this.x = x;
	}


	public Double getY() {
		return y;
	}


	public void setY(Double y) {
		this.y = y;
	}


	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}


	public Integer getNbRentals() {
		return nbRentals;
	}


	public void setNbRentals(Integer nbRentals) {
		this.nbRentals = nbRentals;
	}


	public Double getTotalCharge() {
		return this.totalCharge;
	}


	public void setTotalCharge(Double totalCharge) {
		this.totalCharge = totalCharge;
	}
	
	public Bicycle getRentedBicycle() {
		return rentedBicycle;
	}
	
	public void setRentedBicycle(Bicycle rentendBicycle) {
		this.rentedBicycle = rentedBicycle;
	}

	public void setTotalTime(Double totalTime) {
		this.totalTime = totalTime;
	}
	
	public Double getTotalTime() {
		return this.totalTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", x=" + x + ", y=" + y + ", card=" + card
				 + ", nbRentals=" + nbRentals + ", totalCharge=" + totalCharge + ", totalTime=" + totalTime + "]";
	}
	
	
	
	public void takeBicycle(Station station, BicycleType bicycleType ) {
		for (ParkingSlot parkingSlot : station.getParkingSlots().values()) {
			if (parkingSlot.getStatus().name() == "Occupied" && parkingSlot.getBicycle().getType() == bicycleType) {	
				// If there is a wanted bicycle in the station
				
				this.setRentedBicycle(parkingSlot.getBicycle());		
				// The user rents the bike
				
				parkingSlot.setStatus("Free");
				parkingSlot.setBicycle(null);
				// The bicycle is deleted from the station
				
				station.setRentOperations(station.getRentOperations() + 1) ;
			}
		}
		
		
	}
	
	// User n'a pas loué de vélo, user n'est pas aux bonnes coordonnées, 
	public void dropBicycle(Station station, Double duration) {
		for (ParkingSlot parkingSlot : station.getParkingSlots().values()) {
			if (parkingSlot.getStatus().name() == "Free") {
				// If there is an alvailable slot in the station
				
				parkingSlot.setStatus("Occupied");
				parkingSlot.setBicycle(this.rentedBicycle);
				// The bicycle is stored in the slot
				
				Double cost = this.chargeTravel(this.getCard(), this.getRentedBicycle(), duration);
				
				this.setRentedBicycle(null);
				// The user drops the bike
				
				this.totalCharge += cost;
				this.nbRentals ++;
				this.totalTime += duration;
				
				if (station.getStationType().name() == "Plus" && this.getCard() instanceof VelibreCard) {
					this.getCard().setTimeBalance(this.getCard().getTimeBalance() + 5.);
					this.creditEarned += 5.;				
				}
				
				station.setRentOperations(station.getRentOperations() + 1) ;
				station.setReturnOperations(station.getReturnOperations() + 1) ;			}
		}
	}
	
	// duration in minutes
	public Double chargeTravel(Card card, Bicycle bicycle, Double duration) {
		Double cost = 0.;
		
		if(this.getCard() == null) {
			if (this.getRentedBicycle().getType().name() == "Mechanical" ) {
				cost = duration/60 * 1;
			}
			else if (this.getRentedBicycle().getType().name() == "Electrical" ) {
				cost = duration/60 * 2;
			}
		}
		
		else if (this.getCard() instanceof VelibreCard) {
			if (this.getRentedBicycle().getType().name() == "Electrical" ) {
				duration -= this.getCard().getTimeBalance();
				this.getCard().setTimeBalance(0.);
				if (duration < 60) {
					cost = duration/60 * 1;
				}
				else {
					cost = 1 + (duration-60)/60 * 2;
				}
			}
			
			else if (this.getRentedBicycle().getType().name() == "Mechanical") {
				if (duration - this.getCard().getTimeBalance() < 60) {
					cost = 0.;
					this.getCard().setTimeBalance(this.getCard().getTimeBalance() - (60-duration));
				}
				else {
					duration -= this.getCard().getTimeBalance();
					this.getCard().setTimeBalance(0.);
					cost = (duration-60)/60 * 1;
				}
			}
		}	
		
		else if (this.getCard() instanceof VmaxCard) {
			if (duration < 60) {
					cost = 0.;
			}
			else {
				cost = duration/60 * 1;
				}
			}
		return cost;
	}
	
	
	

	
}
