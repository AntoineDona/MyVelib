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

	@Override
	public int hashCode() {
		int prime = 29;
		int result = 1;
		result = prime * result + id;
		result = prime * result + type.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicycle other = (Bicycle) obj;
		return id == other.id && type == other.type;
	}
	
	
	
}
