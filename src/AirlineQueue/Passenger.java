package AirlineQueue;

import java.util.Random;

/** A class to represent a passenger. */
public class Passenger {

	// Data Fields
	/** The ID number for this passenger. */
	private int passengerId;
	/** The time needed to process this passenger. */
	private int processingTime;
	/** The time this passenger arrives. */
	private int arrivalTime;
	/** The maximum time to process a passenger. */
	private static int maxProcessingTime;
	/** The sequence number for passengers. */
	private static int idNum = 0;
	/** Create a new passenger.
	@param arrivalTime The time this passenger arrives */
	public Passenger(int arrivalTime) {
	this.arrivalTime = arrivalTime;
	Random randomTime = new Random();
	setProcessingTime(1 + randomTime.nextInt(getMaxProcessingTime()));
	setIdNum(getIdNum() + 1);
	this.passengerId = getIdNum();
	}
	/** Get the arrival time.
	@return The arrival time */
	public int getArrivalTime() {
	return arrivalTime;
	}
	/** Get the processing time.
	@return The processing time */
	public int getProcessingTime() {
	return processingTime;
	}
	/** Get the passenger ID.
	@return The passenger ID */
	public int getId() {
	return passengerId;
	}
	/** Set the maximum processing time
	@param maxProcessTime The new value */
	public static void setMaxProcessingTime(int maxProcessTime) {
	maxProcessingTime = maxProcessTime;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getMaxProcessingTime() {
		return maxProcessingTime;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		Passenger.idNum = idNum;
	}
}
