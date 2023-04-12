package data;

import java.io.File;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3ColorSensor;
<<<<<<< Updated upstream
import lejos.hardware.sensor.EV3UltrasonicSensor;

=======

/**
 * 
 * @author Joonas
 *
 */
>>>>>>> Stashed changes
public class ColorSensor extends Thread {
    DataExchange DEObj;
    private EV3ColorSensor colorSensor;
    private EV3UltrasonicSensor us;
    private MotorController motorController = new MotorController();
    
    private long lastLineTime = 0;

    /**
     * @param DE DataExchange for the EV3 Color sensor
     */
    public ColorSensor(DataExchange DE) {
        DEObj = DE;
        colorSensor = new EV3ColorSensor(SensorPort.S3);
    }
<<<<<<< Updated upstream
    
=======
    /**
     * Executable code for the Color sensor
     */
>>>>>>> Stashed changes
    @Override
    public void run() {
        // create a color sensor object on port 4      
        // get the red color mode sample provider
        SampleProvider redMode = colorSensor.getRedMode();

        // define the black and white threshold values
        float blackThreshold = 0.15f;
        float whiteThreshold = 0.25f;
    
        long timeThreshold = 1000;
        
        

        while (true) {
            float[] redSample = new float[redMode.sampleSize()];
            redMode.fetchSample(redSample, 0);
            float redValue = redSample[0];
            
            if (DEObj.getCMD() == 1)
            

            if (blackThreshold <= redValue && redValue <= whiteThreshold) {
                motorController.moveForward(100);
                lastLineTime = System.currentTimeMillis();
            } else {

                if (System.currentTimeMillis() - lastLineTime > timeThreshold) {
                    motorController.turnRight(175, 25);
                } else if (redValue < whiteThreshold) {
                    motorController.turnRight(175, 25);
                } else {
                    motorController.turnLeft(25, 175);
                }
            }
            
            if (Button.ESCAPE.isDown()) {
                System.exit(0);
            }
        }
    }
}
