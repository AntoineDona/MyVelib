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
	private Double totalCharge = 0.;
	
	
	public User(Integer id, String name, Double x, Double y, Card card, Integer nbRentals,
			Double totalCharge) {
		super();
		this.id = idCounter;
		this.name = name;
		this.x = x;
		this.y = y;
		this.card = card;
		this.nbRentals = nbRentals;
		this.totalCharge = totalCharge;
		idCounter ++;
	}
	
	
	public User(Integer id, String name, Double x, Double y) {
		super();
		this.id = idCounter;
		this.name = name;
		this.x = x;
		this.y = y;
		idCounter ++;
	}


	public User(Integer id, String name) {
		super();
		this.id = idCounter;
		this.name = name;
		idCounter ++;
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


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", x=" + x + ", y=" + y + ", card=" + card
				 + ", nbRentals=" + nbRentals + ", totalCharge=" + totalCharge + "]";
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
				
				
			}
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
		else if (this.getCard() instanceof VelibCard) {
			if (this.getRentedBicycle().getType().name() == "Electrical" ) {
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
					this.getCard().getTimeBalance()
					cost = (duration-60)/60 * 1;
				}
			}
		}
		
		
		
		else if (this.getCard() instanceof VmaxCard) {
			if (duration < 60 ) {
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
					cost = (duration-60)/60 * 1;
				}
			}
		}
		return cost;
	}
	
	
	

	
}
