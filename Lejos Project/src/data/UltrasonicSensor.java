package data;

import lejos.hardware.Button;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class UltrasonicSensor extends Thread{
//private DataExchange DEObj;

private EV3UltrasonicSensor us;
private final int securityDistance = 25;

public UltrasonicSensor(DataExchange DE){
//	DEObj = DE;
	us = new EV3UltrasonicSensor(SensorPort.S1);
	
}
	public void run() {
		
	SampleProvider sp = us.getDistanceMode();
		
	while (Button.ESCAPE.isUp()) {
		float[] distanceSample = new float[sp.sampleSize()];
		sp.fetchSample(distanceSample, 0);
		float distance = distanceSample[0] * 100;
		if (distance > securityDistance) {
//			DEObj.setCMD(1); (jatka)

		} else {
//			DEObj.setCMD(0); (kierrä)
			//LCD Output 
			LCD.drawString("Object found!", 0,1);
			LCD.refresh();
			Sound.buzz();

			}
		}
	}
}