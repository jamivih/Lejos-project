package data;

import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class MotorController {
    public void moveForward(int speed) {
        Motor.A.setSpeed(speed);
        Motor.B.setSpeed(speed);
        Motor.A.forward();
        Motor.B.forward();
    }

    public void turnLeft(int speedA, int speedB) {
        Motor.A.setSpeed(speedA);
        Motor.B.setSpeed(speedB);
        Motor.A.forward();
        Motor.B.forward();
    }

    public void turnRight(int speedA, int speedB) {
        Motor.A.setSpeed(speedA);
        Motor.B.setSpeed(speedB);
        Motor.A.forward();
        Motor.B.forward();
    }

    public void moveBackward(int speed) {
        Motor.A.setSpeed(speed);
        Motor.B.setSpeed(speed);
        Motor.A.backward();
        Motor.B.backward();
    }

    public void stop() {
        Motor.A.stop();
        Motor.B.stop();
    }
    
    public void performObstacleAvoidance() {
        moveBackward(150);
        Delay.msDelay(2000);
           
        turnLeft(75, 150);
        Delay.msDelay(3000);
        
        turnRight(150, 75);
        Delay.msDelay(5000);
        
    }
}
