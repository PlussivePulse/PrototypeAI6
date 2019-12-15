package ccc.interaction.global;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cmdExecute {
	
	private String command = "";
	private static Runtime runTime;
	
	private static Process staticProcess;
	
	public void setCommand (String command) {
		this.command = command;
	}
	
	public static void execute(String command) {
		
		Process process = null;
		runTime = Runtime.getRuntime();
		try {
			process = runTime.exec(command);
		} catch (IOException e) {
			popUpBox.alertError(e.toString(), "Error");
			e.printStackTrace();
		}
		if(process == null) {
		}
		BufferedReader reader = new BufferedReader( new InputStreamReader (process.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader (process.getErrorStream()));
	}
	
	public void customExecute() { //experiment
		
		staticProcess = null;
		runTime = Runtime.getRuntime();
		
		String command = "";
		while (!command.equals("end")) {
			
		}
	}
}
