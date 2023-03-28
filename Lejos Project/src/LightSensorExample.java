import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.utility.Delay;

public class LightSensorExample {
    
    public static void main(String[] args) {
        
        // Initialize light sensor on port 1
        EV3ColorSensor lightSensor = new EV3ColorSensor(SensorPort.S1);
        
        // Set light sensor to measure reflected light intensity
        lightSensor.setCurrentMode("Red");
        
        // Read and print light sensor values for 10 seconds
        long endTime = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < endTime) {
            float[] sample = new float[1];
            lightSensor.getRedMode().fetchSample(sample, 0);
            int reflectedLight = (int)(sample[0] * 100);
            System.out.println("Reflected light intensity: " + reflectedLight);
            Delay.msDelay(500);
        }
        
        // Close light sensor port when finished
        lightSensor.close();
    }
}
