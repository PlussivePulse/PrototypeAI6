package ccc.mainComponent.regconizeCore;

import java.awt.Image;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ccc.interaction.global.autoNotificationPusher;
import ccc.interaction.global.cmdExecute;
import ccc.interaction.global.directorySelector;
import ccc.interaction.global.fileSelector;
import ccc.interaction.global.globalInteractionService;
import ccc.interaction.global.notificationFrame;
import ccc.interaction.global.popUpBox;
import ccc.interaction.global.addons.programsMaskFilter;
import ccc.interaction.global.database.DateAndTime;
import ccc.interaction.internalFeatures.Base64Encoder;
import ccc.interaction.internalFeatures.Base64EncoderStatic;
import ccc.interaction.internalFeatures.processControl;
import ccc.interaction.internalFeatures.soundBoard;
import ccc.mainComponent.globalID;
import ccc.mainComponent.UI.Explorer;
import ccc.mainComponent.UI.mainRunnerCore;
import ccc.mainComponent.UIComponents.restartApplication;
import ccc.mainComponent.experimental.DEBUG;
import dataInteractingAbility.ReadText;
import dataInteractingAbility.TextFileCreator;
import dataInteractingAbility.createFile;
import dataInteractingAbility.filesCore;
import dataInteractingAbility.processesNet.ProcessesNet;

public class commandsList extends wordsTransformer{
	protected static void runCommand(String commandCheckString) {
		
		String[] splitter = commandCheckString.split(" ");
		
		if(splitter[0].toLowerCase().equals("exit")) {
			
			mainRunnerCore.displayer.append("\nExiting the program.");
			try {
				TimeUnit.SECONDS.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
			
			
		}else if(splitter[0].toLowerCase().equals("encryptpicture")) {
			Base64Encoder b = new Base64Encoder();
			//Base64EncoderStatic.encrypt(fileSelector.DefaultLoadFile().getAbsolutePath());
			//String output[] = {"systemPrint The encrypted picture is exported as text file."};
			//String output[] = {"systemPrint " + Base64EncoderStatic.getFile()};
			globalID.addID(0.1);
			mainRunnerCore.displayer.append("\n" + globalID.getId() + "[INFO] This will take sometime");
			b.encrypt(fileSelector.DefaultLoadFile().getAbsolutePath());
			TextFileCreator.createTxtFile(b.getFile());
			String output[] = {"systemPrint " + "file has been encrypted."};
			wordsTransformer.output = output;

		}else if(splitter[0].toLowerCase().equals("decryptpicture")) {
			//Base64EncoderStatic.encrypt(fileSelector.DefaultLoadFile().getAbsolutePath());
			//String output[] = {"systemPrint The encrypted picture is exported as text file."};
			//String output[] = {"systemPrint " + Base64EncoderStatic.getFile()};
			globalID.addID(0.1);
			
			//b.DecryptPicture(ReadText.getPlainText());
			String out = ReadText.getPlainText();
			createFile.createFile(out,directorySelector.DirectorySelector() + "\\" + popUpBox.askStringBox("File Name", "Please Enter File name and Format."));
			wordsTransformer.output = output;	
			
		}else if(splitter[0].equals("pc")) {
			//check permission
			if(splitter.length>1) {
				if(splitter[1].equals("shutdown") && splitter.length<3) {
					String output[] = {"systemPrint " + ": shutting down the computer."};
					if(globalInteractionService.getOsVersion().contains("Window")) {
						cmdExecute.execute("shutdown -s -t 60");
					}
					
					wordsTransformer.output = output;
				}else if(splitter[1].equals("shutdown") && splitter.length==3) {
				 
						if(globalInteractionService.getOsVersion().contains("Window")) {
							if(splitter[2].matches("-?\\d+")) {
							cmdExecute.execute("shutdown -s -t "+splitter[2]);
							String output[] = {"systemPrint " + ": shutting down the computer in " + splitter[2] + " seconds."};
							wordsTransformer.output = output;
							unCoreProcessor.customRe = "shutting down the computer in " + splitter[2] + " seconds.";
							}else if(splitter[2].equals("cancel")){
								cmdExecute.execute("shutdown -a");
								unCoreProcessor.customRe = "systemPrint " + ": cancel shutdown process.";
							}
						}
						
			
				}else if (splitter[0].equals("pc") && splitter[1].equals("shutdown") && splitter.length==4){
					String output[] = {"systemPrint " + ": invalid format (pc\\shutdown\\(time or blank))"};
					wordsTransformer.output = output;
				}
				
				else if (splitter[0].equals("pc") && splitter[1].equals("getos")){
					String output[] = {"systemPrint " + globalInteractionService.getOsVersion()};
					wordsTransformer.output = output;
				}
				
				else if (splitter[0].equals("pc") && splitter[1].equals("killtask")){
					if(globalInteractionService.getOsVersion().contains("Window")) {
						processControl.killProcessMenu();
						String output[] = {"systemPrint " + "Opened Processes Terminator Menu."};
						wordsTransformer.output = output;
					}else {
						String output[] = {"systemPrint " + "Unsupport Operating System."};
						wordsTransformer.output = output;
					}
				}

				//Mark : get task manager process
				else if (splitter[0].equals("pc") && splitter[1].equals("gettask")){
					if(globalInteractionService.getOsVersion().contains("Window")) {
						try {
							mainRunnerCore.displayer.append("\nShowing all tasks...");
							globalID.addID(0.1);
							mainRunnerCore.displayer.append("\n"+ ProcessesNet.getProcessPanel());
						} catch (IOException e) {
							e.printStackTrace();
						}
						String output[] = {"systemPrint " + "Loaded all tasks."};
						wordsTransformer.output = output;
					}else {
						String output[] = {"systemPrint " + "Unsupport Operating System."};
						wordsTransformer.output = output;
					}
				}
		}
			
			if (splitter[0].equals("pc") && splitter.length==1){
			String output[] = {"systemPrint " + ": invalid format (pc/command)"};
			wordsTransformer.output = output;
			}
			
		}else if(splitter[0].equals("help")){
			//load text file and send as output
			String output[] = {"systemPrint " + "this feature is coming."};
			wordsTransformer.output = output;
		}else if(splitter[0].equals("explorer")){
			Explorer.start();
		}
		
		else if(splitter[0].equals("say")){
			String text = "";
			for(int i =1; i<splitter.length; i++) {
				text = text + " " + splitter[i] ;
			}
			soundBoard s = new soundBoard();
			s.readLineDefaultExpr(text);
			notificationFrame.generate(text);
			//String output[] = {"systemPrint " + ": say" + text};
			//wordsTransformer.output = output;
			
		}else if(splitter[0].toLowerCase().equals("apptrapmode")) {
			try {
				if(splitter[1]!=null) {
					if(splitter[1].equals("start")) { 
						//depricated 11/25/2019
					}
				}
			}catch(Exception e){
				System.out.println("apptrapmode normal operation.");
			}
			Thread betaAppTrap = new Thread() {
				public void run() {
					programsMaskFilter.start();
				}
			};
			betaAppTrap.start();
			String output[] = {"systemPrint " + "Apptrap mode initiated."};
			wordsTransformer.output = output;

		}else if(splitter[0].equals("evac")){
			filesCore.moveEmg();
		}else if(splitter[0].equals("date")){
			String output[] = {"systemPrint " + DateAndTime.getDAT()};
			wordsTransformer.output = output;
		}else if(splitter[0].equals("restart")){
			new restartApplication();
		}else {
			String output[] = {"systemPrint " + "invalid command. (/help for more information.)"};
			wordsTransformer.output = output;
		}
		prefixTransformer.command = false;
		
	}
}
