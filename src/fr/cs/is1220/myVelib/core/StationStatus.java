package fr.cs.is1220.myVelib.core;


public enum StationStatus {
	OnService,Offline;
	
	public static void main(String[] args) {
		StationStatus[] enumArray = StationStatus.values();
		for (StationStatus value : enumArray) {
			System.out.println(value);
		}
	}
	
}
