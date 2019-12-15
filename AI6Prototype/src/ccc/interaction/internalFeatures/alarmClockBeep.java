package ccc.interaction.internalFeatures;

public class alarmClockBeep {

	public alarmClockBeep() {
		Thread beep = new Thread(new beeper());
		beep.start();
	}
	
	public class beeper implements Runnable {

		private boolean terminator = true;

		@Override
		public void run() {
			
			while(terminator==true) {
				for(int i = 0; i < 3; i++) {
					soundBoard.generateBeepSound(1000, 100, 1);
					
					try {Thread.sleep(5);} 
					catch (InterruptedException e) {e.printStackTrace();}
					
				}
				soundBoard.generateBeepSound(1000, 100, 1);
				try {Thread.sleep(800);} 
				catch (InterruptedException e) {e.printStackTrace();}
			}
		}
		
	}

}
