package fr.cs.is1220.myVelib.core;

public abstract class Card {
	private static Integer idCounter = 1;
	private Integer id;
	private Double timeBalance = 0.;
	
	public Card() {
		super();
		this.id = idCounter;
		idCounter ++;
	}

	public Card(Double timeBalance) {
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
