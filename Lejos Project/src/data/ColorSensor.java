package data;

import java.io.File;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class ColorSensor extends Thread {
	DataExchange DEObj;

	private EV3ColorSensor colorSensor;
	private EV3UltrasonicSensor us;

	
	public ColorSensor(DataExchange DE) {
		DEObj = DE;
		colorSensor = new EV3ColorSensor(SensorPort.S4);
//		us = new EV3UltrasonicSensor(SensorPort.S1);
	}
    @Override
    public void run() {
        // create a color sensor object on port 4      
        // get the red color mode sample provider
        SampleProvider redMode = colorSensor.getRedMode();

        // define the black and white threshold values
        float blackThreshold = 0.15f;
        float whiteThreshold = 0.55f;
        
        
        // continuously read and print the detected color
        while (Button.ESCAPE.isUp()) {
        	float[] redSample = new float[redMode.sampleSize()];
            redMode.fetchSample(redSample, 0);
            float redValue = redSample[0];         
        	if (DEObj.getCMD() == 1) {              
	            if (blackThreshold < redValue && redValue <= whiteThreshold) {
	            	Motor.A.setSpeed(100);
	            	Motor.B.setSpeed(100);
	            	Motor.A.forward();
	            	Motor.B.forward();
	            } else if (redValue < whiteThreshold) {
	            	Motor.A.setSpeed(100);
	            	Motor.B.setSpeed(30);
	            	Motor.A.forward();
	            	Motor.B.forward();
	            } else {
	            	Motor.A.setSpeed(30);
	            	Motor.B.setSpeed(100);
	            	Motor.A.forward();            	
	            	Motor.B.forward();
	            }
        	} else {            	
            	Motor.A.setSpeed(100);
            	Motor.B.setSpeed(100);
            	Motor.A.backward();            	
            	Motor.B.backward();
            	Delay.msDelay(2500);
            	
            	Motor.B.stop();
            	Motor.A.stop();
            	Sound.playSample(new File("haista.wav"), Sound.VOL_MAX);
            	
            	Motor.A.setSpeed(500);
            	Motor.B.setSpeed(500);
            	Motor.A.forward();
            	Motor.B.forward();
            	Delay.msDelay(3000);
            	
	            }
        	}
        }
    }