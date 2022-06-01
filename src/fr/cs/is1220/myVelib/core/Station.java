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
	
}
