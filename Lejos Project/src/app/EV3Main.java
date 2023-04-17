package app;

import data.*;

/**
 * 
 * @author 
 *
 */
public class EV3Main {
	private static DataExchange DE;
	private static ColorSensor LFObj;
	private static ObstacleDetector ODObj;

	/**
	 * Main application for the EV3
	 * 
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {

		DE = new DataExchange();
		ODObj = new ObstacleDetector(DE);
		LFObj = new ColorSensor(DE);
		ODObj.start();
		LFObj.start();
		
	}

}