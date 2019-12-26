package ccc.mainComponent.regconizeCore;

import java.util.ArrayList;
import java.util.Random;

import ccc.interaction.global.NetworkSurface;
import ccc.mainComponent.globalID;
import ccc.mainComponent.UI.mainRunnerCore;
import ccc.mainComponent.experimental.DEBUG;
import servicePackage.stabilizer;

public final class unCoreProcessor {

	private static String[] i = {};
	private static String currentAnswer = "";
	
	private static String returningAnswer = "";
	public static boolean bounded = true;
	
	public static String customRe = "";
	
	public static ArrayList<String> contain = new ArrayList<String>();
	private static boolean proNounExist = false;
	private static boolean possibleAnswer = false;
	private static boolean verbPronounCalculated;
	
	public static String getInput (String[] stream) {
		i = stream; //copy
		//globalID.addPendingQuestion(); //TEMPORARY! //////////////////////////////////
		
		if(globalID.getPendingQuestion()>0) {
			currentAnswer = stream[0];
			
			if(currentAnswer.contains("singleInput")) {
				
				if(stream.length>1) {
					returningAnswer = "tryingToUnderstand";
				}
					
				else {returningAnswer = processCore.process();
				}
			}
			
		}else if (globalID.getPendingQuestion()==0){
			try {
				if(stream[0].contains("singleInput")) {
					returningAnswer = "I am not sure I'm understand. (No Question Asked - Got an Answer.)";
				}}catch(ArrayIndexOutOfBoundsException e){
				bounded = false;
				customRe = "something I can't handle yet.";
			}
		}
		
		if(bounded == true) {
			if(stream[0].length()>11) {
				if(stream[0].substring(0,11).equals("systemPrint")) {
					returningAnswer = stream[0];
				}
			}
			if(stream[0].contains("systemExecute")) {
				
			}else if(stream[0].contains("greeting") || stream[0].contains("supportAnswer")) {
				stream[0] = stream[0].replace("(greeting)", "");
				stream[0] = stream[0].replace("(supportAnswer)", "");
				returningAnswer = stream[0].substring(0,1).toUpperCase() + stream[0].substring(1);
				int randomNum = new Random().nextInt(2);
				if(randomNum==1) {
					returningAnswer += ", Ready at your service.";
				}else if(randomNum==2) {
					//good morning
				}
				
				if(stream.length>1) { //single greeting
					if(stream[1].contains("multi") || stream[1].contains("timeWord") ) {
						stream[0] = stream[0].replace("(greeting-multi)", "");
						//old support for 2 words
						stream[0] = stream[0].replace("(split-Connect)", " ");
						
						stream[1] = stream[1].replace("(timeWord)", " ");
						customRe = stream[0] + stream[1];
					}else {
						customRe = "something is wrong.";
					}
				}
				

				
				
			}
			
			

			
			if(stream.length>2)
				if(stream[2].contains("supportAnswer")) {
					DEBUG.print("");
					if(stream[0].contains("pronoun")) {
						if(globalID.getPendingQuestion()==0) {
							returningAnswer = "Good!";
						}else if(globalID.getPendingQuestion()>0) {
							returningAnswer = "Good!";
						}
					}
				}
			
			if(stream.length==1) { //single greeting
				if(stream[0].contains("testing")) {
					if(mainRunnerCore.displayer!=null) {
						mainRunnerCore.displayer.append("\n" + globalID.getId() + "System : Stabilizer Status : " + stabilizer.getStabilizerValue());
						globalID.addID(0.1);
						mainRunnerCore.displayer.append("\n" + globalID.getId() + "System : Network Surface - Network connection = " + NetworkSurface.isConnected());
						globalID.addID(0.1);
					}
					returningAnswer = "Test Test!";
				}
			
			}
			
			if(stream.length==1) { //single greeting
				if(stream[0].contains("say") && !stream[0].contains("/")) {
					returningAnswer = "User uses sound command";
				}
			
			}
		}
		
		if(stream[0].contains("pronoun")) {
			if(stream[0].contains("pronoun1")){
				contain.add(stream[0]);
				proNounExist = true;
				possibleAnswer = true;
			}
			if(stream[0].contains("pronoun2")){
				contain.add(stream[0]);
				proNounExist = true;
				possibleAnswer = true;
			}
			if(stream[0].contains("pronounI")){
				contain.add(stream[0]);
				proNounExist = true;
				possibleAnswer = true;
			}
			
			if(proNounExist == true && stream[1].contains("verb")) {
				verbPronounCalculated = true;
				if(stream.length>=3) {
					int targetDelete = (stream[2].indexOf(")"));
					stream[2] = stream[2].substring(targetDelete+1);
					if(stream[1].contains("is")
							||stream[1].contains("am")
							||stream[1].contains("are")
							||stream[1].contains("am")
							||stream[1].contains("was")
							||stream[1].contains("were")) {
						if(stream.length<4) {
							DEBUG.print(stream[2]);
						}
					}
				}
			}
		}
		
		//patch non-reset variable make returningAnswer not updating
		if(!customRe.equals("")) {
			returningAnswer = customRe;
			customRe = "";
		}
	
		//reset
		proNounExist = false;
		contain = new ArrayList<String>();
		possibleAnswer = false;
		
		return "[Plusai] : " + returningAnswer;
	}
	
}
