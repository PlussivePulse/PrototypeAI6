package servicePackage;

import ccc.interaction.global.notificationBox;
import ccc.interaction.global.popUpBox;
import ccc.interaction.global.database.DateAndTime;
import internalSecurity.emergencyStop;

public final class serviceLoader {
	
	private static ccc.interaction.global.globalInteractionService gIS;
	private static ccc.mainComponent.GISSupporter gISSupport;
	private static ccc.interaction.global.database.globalInteractionDB globalIDB = new ccc.interaction.global.database.globalInteractionDB();
	private static ccc.interaction.global.addons.globalInteractionComponent globalIC;
	private static ccc.interaction.global.popUpBox popUpCore;
	private static ccc.mainComponent.GISSupporter gISSup;
	private static notificationBox notiBox;
	private static ccc.interaction.global.notificationFrame notiFrame;
	private static internalSecurity.emergencyStop emergStop;
	
	private static int loadCount = 0;
	/////////////////////////////////////////////////////////////////////////////
	
	public static ccc.interaction.global.globalInteractionService getGLobalInteractionService(){return gIS;}
	public static ccc.mainComponent.GISSupporter getGISSupport(){return gISSupport;}
	public static internalSecurity.emergencyStop getemerg(){return emergStop;}
	
	public static void loadID(String value) {
		if(value.equals("gIS")) {
			gIS = new ccc.interaction.global.globalInteractionService();
			loadCount++;
		}
		
		else if(value.equals("gISSupport")) {
			gISSupport = new ccc.mainComponent.GISSupporter();
			if(gISSupport!=null)
			{
				if(gISSupport.local_traySupport()==true||gISSupport.local_traySupport()==false) {
					loadCount++;
				}
			}
		}
		else if (value.equals("emergStop")) {
			emergStop = new emergencyStop();
			if(emergStop != null) {loadCount++;}
		}
		
		if(DateAndTime.datNull()==false) {
			loadCount++;
		}else {
			DateAndTime.setLocalDaT();
			if(DateAndTime.datNull()==false) {
				loadCount++;
			}else {
				popUpBox.alertError("Unable to load DateAndTime.","ServiceLoader Alert :");
			}
		}
	}
}
