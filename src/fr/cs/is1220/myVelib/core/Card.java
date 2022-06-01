package fr.cs.is1220.myVelib.core;

public abstract class Card {
	private static Integer idCounter = 0;
	private Integer id;
	private Double timeBalance = 0.;
	
	public Card(Integer id, Double timeBalance) {
		super();
		this.id = idCounter;
		this.timeBalance = timeBalance;
		idCounter ++;
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
