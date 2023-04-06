package data;

import lejos.hardware.Button;
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

    private final int securityDistance = 10;
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

        while (true) {
            sp.fetchSample(distanceSample, 0);
            float distance = distanceSample[0] * 100;
            if (distance > securityDistance) {
                DEObj.setCMD(1);
            } else {
                DEObj.setCMD(0);
                LCD.drawString("Avoid Obstacle", 0, 0);
                LCD.refresh();
                motorController.performObstacleAvoidance();
                DEObj.setCMD(1);
                LCD.clear();
            }
            
            if (Button.ESCAPE.isDown()) {
                System.exit(0);
            }
        }
    }
}
