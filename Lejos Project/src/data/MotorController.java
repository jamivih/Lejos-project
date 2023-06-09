package data;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

/**
 * 
 * @author Jan
 * @version 04/12/2023
 */

public class MotorController {

	/**
	 * 
	 * @param speed
	 */
	public void moveForward(int speed) {
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Motor.A.forward();
		Motor.B.forward();
	}

	/**
	 * 
	 * @param speedA
	 * @param speedB
	 */
	public void turnLeft(int speedA, int speedB) {
		Motor.A.setSpeed(speedA);
		Motor.B.setSpeed(speedB);
		Motor.A.forward();
		Motor.B.forward();
	}

	/**
	 * 
	 * @param speedA
	 * @param speedB
	 */
	public void turnRight(int speedA, int speedB) {
		Motor.A.setSpeed(speedA);
		Motor.B.setSpeed(speedB);
		Motor.A.forward();
		Motor.B.forward();
	}

	/**
	 * 
	 * @param speed
	 */
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
		turnRight(150, 90);
		Delay.msDelay(2500);

		turnLeft(90, 150);
		Delay.msDelay(5000);

		turnRight(150, 70);
		Delay.msDelay(1200);

	}

	public void add1() {

		int count = 0;
		count += 1;

		if (count == 2) {

			System.exit(0);
		}

	}

}
