package fr.cs.is1220.myVelib.core;

public class Bicycle {
	private static Integer idCounter = 1;
	private Integer id;
	private BicycleType type;
	
	public Bicycle(BicycleType type) {
		super();
		this.id = idCounter;
		this.type = type;
		idCounter++;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BicycleType getType() {
		return type;
	}
	public void setType(BicycleType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", type=" + type + "]";
	}
	
}
