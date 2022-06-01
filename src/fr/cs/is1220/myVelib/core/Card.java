package fr.cs.is1220.myVelib.core;

public abstract class Card {
	private static Integer idCounter = 0;
	private Integer id;
	private Double timeBalance = 0.;
	
	public abstract Double chargeTravel(BicycleType bicycleType, Double duration);

	public Card(Integer id, Double timeBalance) {
		super();
		this.id = id;
		this.timeBalance = timeBalance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTimeBalance() {
		return timeBalance;
	}

	public void setTimeBalance(Double timeBalance) {
		this.timeBalance = timeBalance;
	}
	
}
