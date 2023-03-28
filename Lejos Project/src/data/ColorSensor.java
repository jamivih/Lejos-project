package data;

import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorSensor extends Thread {
    
    @Override
    public void run() {
        // create a color sensor object on port 1
        EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S4);

        // get the red color mode sample provider
        SampleProvider redMode = colorSensor.getRedMode();

        // define the black and white threshold values
        int blackThreshold = 5;
        int whiteThreshold = 40;

        // continuously read and print the detected color
        while (true) {
            float[] redSample = new float[redMode.sampleSize()];
            redMode.fetchSample(redSample, 0);
            float redValue = redSample[0];
            if (redValue < blackThreshold) {
                Sound.beep();
            } else if (redValue > whiteThreshold) {
                Sound.buzz();
            }
            Delay.msDelay(2000); // add delay between value checks
        }
    }
}
