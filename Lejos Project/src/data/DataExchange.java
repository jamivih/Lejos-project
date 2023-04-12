package data;

/**
 * 
 * @author Jami
 * @version 03/28/2023
 */
public class DataExchange {

	private boolean obstacleDetected = false;

	private int CMD = 1;

	/**
	 * Changing data between classes
	 */
	public DataExchange() {
	}

	/**
	 * 
	 * @param status sets obstacle detected
	 */
	public void setObstacleDetected(boolean status) {

		obstacleDetected = status;
	}

	/**
	 * 
	 * @return obstacle detected
	 */
	public boolean getObstacleDetected() {
		return obstacleDetected;
	}

	/**
	 * 
	 * @param command for CMD, which is used in obstacle detector
	 */
	public void setCMD(int command) {
		CMD = command;
	}

	/**
	 * 
	 * @return CMD
	 */
	public int getCMD() {
		return CMD;
	}
}
