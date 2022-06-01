package fr.cs.is1220.myVelib.core;

import java.util.*;

public class Station {
	private static Integer idCounter = 0;
	private Integer id;
	private double x;
	private double y;
	private StationStatus stationStatus;
	private StationType stationType;
	private HashMap<Integer,ParkingSlot> parkingSlots;
	
	public Station(double x, double y, StationStatus stationStatus, StationType stationType,
			HashMap<Integer, ParkingSlot> parkingSlots) {
		super();
		this.id = idCounter;
		this.x = x;
		this.y = y;
		this.stationStatus = stationStatus;
		this.stationType = stationType;
		this.parkingSlots = parkingSlots;
		
		idCounter++;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public StationStatus getStationStatus() {
		return stationStatus;
	}

	public void setStationStatus(StationStatus stationStatus) {
		this.stationStatus = stationStatus;
	}

	public StationType getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = StationType.valueOf(stationType);
	}

	public HashMap<Integer, ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(HashMap<Integer, ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", x=" + x + ", y=" + y + ", stationStatus=" + stationStatus + ", stationType="
				+ stationType + ", parkingSlots=" + parkingSlots + "]";
	}
	
	
}
