package fr.cs.is1220.myVelib.core;

import java.util.Objects;

public class ParkingSlot {
	private static Integer idCounter = 1;
	private Integer id;
	private Bicycle bicycle;
	private ParkingSlotStatus status;
	
	
	public ParkingSlot() {
		super();
		this.id = idCounter;
		this.status = ParkingSlotStatus.valueOf("Free");
		idCounter++;
	}

	public ParkingSlot(Bicycle bicycle) {
		super();
		this.id = idCounter;
		this.bicycle = bicycle;
		this.status = ParkingSlotStatus.valueOf("Occupied");
		idCounter++;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Bicycle getBicycle() {
		return bicycle;
	}
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	public ParkingSlotStatus getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = ParkingSlotStatus.valueOf(status);
	}
	
	@Override
	public String toString() {
		return "ParkingSlot [id=" + id + ", bicycle=" + bicycle + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		int prime = 29;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (bicycle == null ? 0 :  bicycle.hashCode());
		result = prime * result + status.hashCode();
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
		ParkingSlot other = (ParkingSlot) obj;
		return Objects.equals(bicycle, other.bicycle) && Objects.equals(id, other.id) && status == other.status;
	}		
}
