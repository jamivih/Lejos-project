package app;

import data.*;

public class EV3Main {

	public static void main(String[] args) {
		
//		UltrasonicSensor obd = new UltrasonicSensor(null);	
		ColorSensor colorSensor = new ColorSensor();
		
//		obd.start();
		
        colorSensor.start();


	}

}
