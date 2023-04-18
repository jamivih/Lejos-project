package data;

import java.io.File;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
/**
 * 
 * @author Jami
 * @version 03/28/2023
 */
public class ObstacleDetector extends Thread {
    private DataExchange DEObj;
    private EV3UltrasonicSensor us;

    private final int securityDistance = 20;
    private MotorController motorController = new MotorController();

    /**
     * 
     * @param DE DataExchange for the EV3 ultrasonic sensor
     */
    public ObstacleDetector(DataExchange DE) {
        DEObj = DE;
        us = new EV3UltrasonicSensor(SensorPort.S1);
    }

    /**
     *  Executable code for the obstacle detector
     */
    public void run() {
        SampleProvider sp = us.getDistanceMode();
        float[] distanceSample = new float[sp.sampleSize()];

        int count = 0;
        //while looping the ultrasonic sensor for obstacles
        while (true) {
            sp.fetchSample(distanceSample, 0);
            float distance = distanceSample[0] * 100;
            
            //if distance is less than security distance the robot plays the while loop form ColorSensor.java class 
            if (distance > securityDistance) {
                DEObj.setCMD(1);
                
              //if distance is less than security distance the robot performs obstacle avoidance
            } else if (distance < securityDistance) {
            	count += 1;
                Sound.playSample(new File("ohno.wav"), Sound.VOL_MAX);
                
                //when detecting obstacles, on the second detection the program closes
                if (count>=2) {
                	Sound.playSample(new File("shutdown.wav"), Sound.VOL_MAX);
                    System.exit(0);
                } else {
                    	
                  
                DEObj.setCMD(0);
                LCD.drawString("Avoid Obstacle", 0, 0);
                LCD.refresh();
                motorController.performObstacleAvoidance();


                DEObj.setCMD(1);
                LCD.clear();
                
                }
            }

            if (Button.ESCAPE.isDown()) {
                System.exit(0);
                
            }
        }
    }
}
