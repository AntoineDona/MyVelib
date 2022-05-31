package fr.cs.is1220.myVelib.core;

public class ParkingSlot {
	private static Integer idCounter = 1;
	private Integer id;
	private Bicycle bicycle;
	private ParkingSlotStatus status;
	
	public ParkingSlot(Bicycle bicycle, ParkingSlotStatus status) {
		super();
		this.id = idCounter;
		this.bicycle = bicycle;
		this.status = status;
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
	public void setStatus(ParkingSlotStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ParkingSlot [id=" + id + ", bicycle=" + bicycle + ", status=" + status + "]";
	}
		
}
