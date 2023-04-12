package app;

import data.*;

public class EV3Main {
	private static DataExchange DE;
	private static ColorSensor LFObj;
	private static ObstacleDetector ODObj;
	
	public static void main(String[] args) {
		
		DE = new DataExchange();
		ODObj = new ObstacleDetector(DE);	
		LFObj = new ColorSensor(DE);		
		ODObj.start();		
		LFObj.start();
		
		if (System.currentTimeMillis() >= 60000) {
            System.exit(0);
	}
	

}