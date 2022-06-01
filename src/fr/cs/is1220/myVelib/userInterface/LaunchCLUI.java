package fr.cs.is1220.myVelib.userInterface;
import java.util.Scanner;

public class LaunchCLUI {
	public static void main(String[] args) {
		System.out.println("Launching myVelib App ...");
		System.out.println("Welcome on MyVelib App! To display a list of commands, type 'help'");
		Scanner input = new Scanner(System.in); // Allows command input
		
		boolean end = false;
		String commandLine;
		
		while(!end) {
			commandLine = input.nextLine();
			if (commandLine.equalsIgnoreCase("exit")) {
				input.close();
				end = true;
	    		System.out.println("You closed the CLUI.");
			}
			else {
				//get and execute command
			}
		}
		
	}
	public String readLineByLine(String Filename) {
		return "";
	}
}
