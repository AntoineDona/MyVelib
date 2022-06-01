package fr.cs.is1220.myVelib.userInterface;

import java.util.*;
import fr.cs.is1220.myVelib.core.*;

public class Command {
	public void run(String command) {
		
		ArrayList<String> props = new ArrayList<String>(Arrays.asList(command.split(" ")));
		String cmd = props.get(0);
		
		MyVelibNetwork net = null;
		
		if(cmd.equalsIgnoreCase("setup")) {
			if (props.size() == 2) {
				String name = props.get(1);
				System.out.println(name);
				net =  MyVelibNetwork(name, 4);
			}
			else if (prop.size() == 6) {
				String name = props.get(1);
				Integer nStations = Integer.parseInt(props.get(2));
				Integer nSlots = Integer.parseInt(props.get(3));
				Double s = Double.parseDouble(props.get(4));
				Integer nBikes = Integer.parseInt(props.get(5));
				
				net = MyVelibNetwork(name, s);
				net.addMultipleStations(nStations, nSlots);
				net.addMultipleBikes(nBikes);
				
			}
		}
		
		else if(cmd.equalsIgnoreCase("addUser")) {
			String userName = props.get(1);
			String cardType = props.get(2);
			net.addUser(userName, cardType);
		}
		
		else if(cmd.equalsIgnoreCase("offline")) {
			Integer stationID = props.get(1);
			net.offline(stationID);
		}
		
		else if(cmd.equalsIgnoreCase("online")) {
			Integer stationID = props.get(1);
			net.online(stationID);
		}
		
		
		
		else if(cmd.equalsIgnoreCase("rentBike")) {
			Integer userID = Integer.parseInt(props.get(1));
			Integer stationID = Integer.parseInt(props.get(2));
			
			// le bon user : user.takeBicycle()
		}
		
		else if(cmd.equalsIgnoreCase("returnBike")) {
			Integer userID = Integer.parseInt(props.get(1));
			Integer stationID = Integer.parseInt(props.get(2));
			Double duration = Double.parseDouble(props.get(3));
			// le bon user : user.dropBicycle
		}
			
		else if(cmd.equalsIgnoreCase("displayStation")) {
			Integer stationID = Integer.parseInt(props.get(1));
			// la bonne station : station.stats
		}
		
		else if(cmd.equalsIgnoreCase("displayUser"){
			Integer userID = Integer.parseInt(props.get(1));
			// le bon user : user.stats
		}
		
		else if(cmd.equalsIgnoreCase("sortStations")) {
			String sortPolicy = props.get(1);
			// Sort by
		}
		
		else if(cmd.equalsIgnoreCase("display")) {
			net.display();
		}
		
	}
}
