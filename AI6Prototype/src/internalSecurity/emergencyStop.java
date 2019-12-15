package internalSecurity;

import servicePackage.serviceLoader;

public class emergencyStop{
	
	protected static void oncePop() {
		serviceLoader loadSrv = new serviceLoader();
		loadSrv.getGLobalInteractionService().emergencyStopCT();
	}
	
	protected static void autoCheckOvrUse() {
		
	}
}
