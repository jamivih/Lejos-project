import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorSensor {

    public static void main(String[] args) {

        // create a color sensor object on port 1
        EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);

        // get the red color mode sample provider
        SampleProvider redMode = colorSensor.getRedMode();

        // define the black and white threshold values
        int blackThreshold = 10;
        int whiteThreshold = 50;

        // continuously read and print the detected color
        while (true) {
            float[] redSample = new float[redMode.sampleSize()];
            redMode.fetchSample(redSample, 0);
            float redValue = redSample[0];
            if (redValue < blackThreshold) {
                System.out.println("Black detected");
            } else if (redValue > whiteThreshold) {
                System.out.println("White detected");
            }
            Delay.msDelay(500);
        }
    }
}