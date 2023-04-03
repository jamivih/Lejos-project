package data;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class ObstacleDetector extends Thread{
	private DataExchange DEObj;
	
	private EV3UltrasonicSensor us;
	private final int securityDistance = 13;

	public ObstacleDetector(DataExchange DE){
		DEObj = DE;
		us = new EV3UltrasonicSensor(SensorPort.S1);
		
	}
	public void run() {		
		SampleProvider sp = us.getDistanceMode();
		float[] distanceSample = new float[sp.sampleSize()];
		
	while (Button.ESCAPE.isUp()) {	
		sp.fetchSample(distanceSample, 0);
		float distance = distanceSample[0] * 100;
		if (distance > securityDistance) {
			DEObj.setCMD(1);

		} else {
			
			DEObj.setCMD(0);
			
			}
		
		
		}
	
	}
	
}