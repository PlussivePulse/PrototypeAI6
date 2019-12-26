package ccc.mainComponent;

import ccc.mainComponent.experimental.DEBUG;
import ccc.mainComponent.regconizeCore.prefixTransformer;
import ccc.mainComponent.regconizeCore.unCoreProcessor;
import ccc.mainComponent.regconizeCore.wordsTransformer;
import ccc.mainComponent.regconizeCore.languages.engDB;
import servicePackage.stabilizer;

public class Systems {

	private boolean empty = false;
	private String handle;
	private String output;
	
	public static String oldText = "";
	
	public String submitString(String text) {
		
		oldText = text;
		
		globalID.addID(1.0);
		prefixTransformer.command = false; //patch command not resetting
		handle = unCoreProcessor.getInput(wordsTransformer.Transform(text));
		DEBUG.print(handle);
		DEBUG.print("\n" + (text));
		
		output = "[" + globalID.getpureId() + "]";
		
		if(text.equals("<empty>")) {
			globalID.addID(0.1);
			handle = text + "\n" + globalID.getId() + AIname.getName() + " : The input can't be empty. <Stabilizer=true>";
			empty = true;

		}
		

		
		if(empty==true) {
			
			text = output + handle;
		}else {
			if(engDB.wrongSpacing==false) {
				text = "[" + globalID.getpureId() + "] " + userID.userID + " : " + text;
			}else {
				text = "[" + globalID.getpureId() + "] " + userID.userID + " : " + engDB.wSHandler;
				engDB.wSHandler = ""; //reset patch memoryLeak
			}
			globalID.addID(0.1);
			text = text + "\n[" + globalID.getpureId() + "]" + handle;
		}

		text = text.replace("systemPrint", "");
		
		wordsTransformer.output = null;
		
		empty = false; //bug patch
		prefixTransformer.command = false;
		unCoreProcessor.customRe = ""; //bugPatcher
		
		return text;
		
	}
}
