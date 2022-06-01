package fr.cs.is1220.myVelib.core;

import java.util.*;

public class Station {
	private static Integer idCounter = 0;
	private Integer id;
	private double x;
	private double y;
	private StationStatus stationStatus = StationStatus.valueOf("OnService");
	private StationType stationType;
	private HashMap<Integer,ParkingSlot> parkingSlots = new HashMap<Integer,ParkingSlot>();
	
	
	
	public Station(StationType stationType) {
		super();
		this.id = idCounter;
		this.stationType = stationType;
		idCounter++;
	}

	public Station(double x, double y, StationType stationType) {
		super();
		this.id = idCounter;
		this.x = x;
		this.y = y;
		this.stationType = stationType;
		this.parkingSlots = parkingSlots;
		
		idCounter++;
	}


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
	
}
