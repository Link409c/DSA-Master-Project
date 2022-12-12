package AirlineQueue;

import java.util.LinkedList;
import java.util.Queue;

/** Class to simulate a queue of passengers. */
public class PassengerQueue {

	// Data Fields
	/**
	 * The queue of passengers.
	 */
	private Queue<Passenger> theQueue;
	/**
	 * The number of passengers served.
	 */
	private int numServed;
	/**
	 * The total time passengers were waiting.
	 */
	private int totalWait;
	/**
	 * The name of this queue.
	 */
	private String queueName;
	/**
	 * The average arrival rate.
	 */
	private double arrivalRate;
	// Constructor

	/**
	 * Construct a PassengerQueue with the given name.
	 *
	 * @param queueName The name of this queue
	 */
	public PassengerQueue(String queueName) {
		setNumServed(0);
		setTotalWait(0);
		this.queueName = queueName;
		setTheQueue(new LinkedList<>());
	}

	public Queue<Passenger> getTheQueue() {
		return theQueue;
	}

	public void setTheQueue(Queue<Passenger> theQueue) {
		this.theQueue = theQueue;
	}

	public int getNumServed() {
		return numServed;
	}

	public void setNumServed(int numServed) {
		this.numServed = numServed;
	}

	public int getTotalWait() {
		return totalWait;
	}

	public void setTotalWait(int totalWait) {
		this.totalWait = totalWait;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public double getArrivalRate() {
		return arrivalRate;
	}

	public void setArrivalRate(double arrivalRate) {
		this.arrivalRate = arrivalRate;
	}


	public boolean isEmpty(){
		return getTheQueue().isEmpty();
	}

	public int size(){
		return getTheQueue().size();
	}

	/**
	 * Check if a new arrival has occurred.
	 *
	 * @param clock   The current simulated time
	 * @param showAll Flag to indicate that detailed
	 *                data should be output
	 */
	public void checkNewArrival(int clock, boolean showAll) {
		if (Math.random() < getArrivalRate()) {
			getTheQueue().add(new Passenger(clock));
			if (showAll) {
				System.out.println("Time is "
						+ clock + ": "
						+ getQueueName()
						+ " arrival, new queue size is "
						+ getTheQueue().size());

			}
		}
	}

	/**
	 * Update statistics.
	 * pre: The queue is not empty.
	 *
	 * @param clock   The current simulated time
	 * @param showAll Flag to indicate whether to show detail
	 * @return Time passenger is done being served
	 */
	public int update(int clock, boolean showAll) {
		Passenger nextPassenger = getTheQueue().remove();
		int timeStamp = nextPassenger.getArrivalTime();
		int wait = clock - timeStamp;
		setTotalWait(getTotalWait() + wait);
		setNumServed(getNumServed() + 1);;
		if (showAll) {
			System.out.println("Time is " + clock
					+ ": Serving "
					+ getQueueName()
					+ " with time stamp "
					+ timeStamp);

		}
		return clock + nextPassenger.getProcessingTime();
	}
}

