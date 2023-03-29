package data;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorSensor extends Thread {
	
    private static final EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S4);
    private static final SampleProvider redMode = colorSensor.getRedMode();

    @Override
    public void run() {
        // create a color sensor object on port 4
        EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S4);

        // get the red color mode sample provider
        SampleProvider redMode = colorSensor.getRedMode();

        // define the black and white threshold values
        float blackThreshold = 0.15f;
        float whiteThreshold = 0.55f;

        Sound.setVolume(10);

        // continuously read and print the detected color
        while (Button.ESCAPE.isUp()) {
            float[] redSample = new float[redMode.sampleSize()];
            redMode.fetchSample(redSample, 0);
            float redValue = redSample[0];

            if (blackThreshold < redValue && redValue <= whiteThreshold) {
                Sound.beep();
            } else if (redValue < whiteThreshold) {
                Sound.buzz();
            } else if (redValue > whiteThreshold) {
                Sound.beepSequence();
            }
        }
    }
    

    public static float[] getRedSample() {
        float[] redSample = new float[redMode.sampleSize()];
        redMode.fetchSample(redSample, 0);
        return redSample;
    }
 }