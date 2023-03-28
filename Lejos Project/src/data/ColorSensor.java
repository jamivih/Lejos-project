package data;
<<<<<<< HEAD
=======

import lejos.hardware.Sound;
>>>>>>> branch 'master' of https://github.com/jamivih/Lejos-project.git
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorSensor extends Thread {
    
    @Override
    public void run() {
        // create a color sensor object on port 4
        EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S4);

        // get the red color mode sample provider
        SampleProvider redMode = colorSensor.getRedMode();

        // define the black and white threshold values
<<<<<<< HEAD
        int blackThreshold = 10;
        int whiteThreshold = 50;
        
=======
        int blackThreshold = 5;
        int whiteThreshold = 70;
>>>>>>> branch 'master' of https://github.com/jamivih/Lejos-project.git

        // continuously read and print the detected color
        while (true) {
            float[] redSample = new float[redMode.sampleSize()];
            redMode.fetchSample(redSample, 0);
            float redValue = redSample[0];
            if (redValue < blackThreshold) {
<<<<<<< HEAD
                System.out.println("Black detected");
=======
                Sound.beep();
>>>>>>> branch 'master' of https://github.com/jamivih/Lejos-project.git
            } else if (redValue > whiteThreshold) {
                System.out.println("White detected");
            }
<<<<<<< HEAD
            Delay.msDelay(500);
=======
            Delay.msDelay(500); // add delay between value checks
>>>>>>> branch 'master' of https://github.com/jamivih/Lejos-project.git
        }
    }
<<<<<<< HEAD

    public static void main(String[] args) {
        // create a new instance of the ColorSensor thread and start it
        ColorSensor colorSensor = new ColorSensor();
        colorSensor.start();
    }
=======
>>>>>>> branch 'master' of https://github.com/jamivih/Lejos-project.git
}
