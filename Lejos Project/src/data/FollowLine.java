//package data;
//
//import data.ColorSensor;
//import lejos.hardware.Button;
//import lejos.hardware.motor.Motor;
//import lejos.utility.Delay;
//
//public class FollowLine extends Thread {
//    private static final int SPEED = 400;
//    private static final float KP = 1.2f; // proportional constant
//
//    private static void setSpeed(int speed) {
//        Motor.A.setSpeed(speed);
//        Motor.B.setSpeed(speed);
//    }
//
//    public static void main(String[] args) {
//        // Start the color sensor thread
//        ColorSensor colorSensor = new ColorSensor();
//        colorSensor.start();
//
//        setSpeed(SPEED);
//
//        System.out.println("Press ENTER to start");
//        Button.ENTER.waitForPressAndRelease();
//
//        while (!Button.ESCAPE.isDown()) {
//            float[] redSample = ColorSensor.getRedSample();
//
//            // Calculate the deviation from the desired line position
//            float deviation = redSample[0] - 0.5f;
//
//            // Adjust the motor speeds based on the deviation
//            int leftSpeed = (int) (SPEED + KP * deviation);
//            int rightSpeed = (int) (SPEED - KP * deviation);
//            Motor.A.setSpeed(leftSpeed);
//            Motor.B.setSpeed(rightSpeed);
//
//            // Move forward
//            Motor.A.forward();
//            Motor.B.forward();
//
//            // Wait a short period before checking again
//            Delay.msDelay(10);
//        }
//
//        // Stop the motors when the program ends
//        Motor.A.stop();
//        Motor.B.stop();
//    }
//}
