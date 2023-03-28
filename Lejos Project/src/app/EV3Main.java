package app;

import data.*;

public class EV3Main {

	public static void main(String[] args) {
		
		UltrasonicSensor obd = new UltrasonicSensor(null);	
		
		obd.start();


	}

}
