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
				net =  new MyVelibNetwork(name, 4.0);
			}
			else if (props.size() == 6) {
				String name = props.get(1);
				
			}
		}
		
		else if(cmd.equalsIgnoreCase("addUser")) {
			String userName = props.get(1);
			String cardType = props.get(2);
			net.addUser(userName, cardType);
		}
		
		else if(cmd.equalsIgnoreCase("offline")) {
			Integer stationID = Integer.parseInt(props.get(1));
			//net.offline(stationID);
		}
		
		else if(cmd.equalsIgnoreCase("online")) {
			Integer stationID = Integer.parseInt(props.get(1));
			//net.online(stationID);
		}
		
		
		
		else if(cmd.equalsIgnoreCase("rentBike")) {
			Integer userID = Integer.parseInt(props.get(1));
			Integer stationID = Integer.parseInt(props.get(2));
			
			
			
	}
		
	}
}
