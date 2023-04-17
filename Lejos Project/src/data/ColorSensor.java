package data;

import java.io.File;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.EV3ColorSensor;

/**
 * 
 * @author Joonas
 *
 */
public class ColorSensor extends Thread {
    DataExchange DEObj;
    private EV3ColorSensor colorSensor;
    private MotorController motorController = new MotorController();
    
    private long lastLineTime = 0;

    /**
     * @param DE DataExchange for the EV3 Color sensor
     */
    public ColorSensor(DataExchange DE) {
        DEObj = DE;
        colorSensor = new EV3ColorSensor(SensorPort.S3);
    }

    /**
     * Executable code for the Color sensor
     */

    @Override
    public void run() {
        // create a color sensor object on port 4      
        // get the red color mode sample provider
        SampleProvider redMode = colorSensor.getRedMode();

        // define the black and white threshold values
        float blackThreshold = 0.10f;
        float whiteThreshold = 0.40f;
    
        long timeThreshold = 1500;
        
        

        while (true) {
            float[] redSample = new float[redMode.sampleSize()];
            redMode.fetchSample(redSample, 0);
            float redValue = redSample[0];
            
            if (DEObj.getCMD() == 1)
            

            if (blackThreshold <= redValue && redValue <= whiteThreshold) {
                motorController.moveForward(150);
//                lastLineTime = System.currentTimeMillis();
            } else {
//                if (System.currentTimeMillis() - lastLineTime > timeThreshold) {
//                    motorController.turnRight(150, 75);
//                } 
                if (redValue < whiteThreshold) {
                    motorController.turnRight(150, 75);
                } else {
                    motorController.turnLeft(75, 150);
                }
            }
            
            if (Button.ESCAPE.isDown()) {
                System.exit(0);
            }
        }
    }
}
