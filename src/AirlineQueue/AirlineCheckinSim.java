package AirlineQueue;

import java.util.Scanner;

/** Simulate the check-in process of an airline.
 */
public class AirlineCheckinSim {
	// Data Fields
	/**
	 * Queue of frequent flyers.
	 */
	private PassengerQueue frequentFlyerQueue =
			new PassengerQueue("Frequent Flyer");
	/**
	 * Queue of regular passengers.
	 */
	private PassengerQueue regularPassengerQueue =
			new PassengerQueue("Regular Passenger");
	/**
	 * Maximum number of frequent flyers to be served
	 * before a regular passenger gets served.
	 */
	private int frequentFlyerMax;
	/**
	 * Maximum time to service a passenger.
	 */
	private int maxProcessingTime;
	/**
	 * Total simulated time.
	 */
	private int totalTime;
	/**
	 * If set true, print additional output.
	 */
	private boolean showAll;
	/**
	 * Simulated clock.
	 */
	private int clock = 0;
	/**
	 * Time that the agent will be done with the current passenger.
	 */
	private int timeDone;
	/**
	 * Number of frequent flyers served since the
	 * last regular passenger was served.
	 */
	private int frequentFlyersSinceRP;

	public PassengerQueue getFrequentFlyerQueue() {
		return frequentFlyerQueue;
	}

	public void setFrequentFlyerQueue(PassengerQueue frequentFlyerQueue) {
		this.frequentFlyerQueue = frequentFlyerQueue;
	}

	public PassengerQueue getRegularPassengerQueue() {
		return regularPassengerQueue;
	}

	public void setRegularPassengerQueue(PassengerQueue regularPassengerQueue) {
		this.regularPassengerQueue = regularPassengerQueue;
	}

	public int getFrequentFlyerMax() {
		return frequentFlyerMax;
	}

	public void setFrequentFlyerMax(int frequentFlyerMax) {
		this.frequentFlyerMax = frequentFlyerMax;
	}

	public int getMaxProcessingTime() {
		return maxProcessingTime;
	}

	public void setMaxProcessingTime(int maxProcessingTime) {
		this.maxProcessingTime = maxProcessingTime;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public boolean isShowAll() {
		return showAll;
	}

	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

	public int getClock() {
		return clock;
	}

	public void setClock(int clock) {
		this.clock = clock;
	}

	public int getTimeDone() {
		return timeDone;
	}

	public void setTimeDone(int timeDone) {
		this.timeDone = timeDone;
	}

	public int getFrequentFlyersSinceRP() {
		return frequentFlyersSinceRP;
	}

	public void setFrequentFlyersSinceRP(int frequentFlyersSinceRP) {
		this.frequentFlyersSinceRP = frequentFlyersSinceRP;
	}

	private void runSimulation() {
		for (setClock(0); getClock() < getTotalTime(); setClock(getClock()+1)) {
			getFrequentFlyerQueue().checkNewArrival(getClock(), isShowAll());
			getRegularPassengerQueue().checkNewArrival(getClock(), isShowAll());
			if (getClock() >= getTimeDone()) {
				startServe();
			}
		}
	}

	private void startServe() {
		if (!getFrequentFlyerQueue().isEmpty()
				&& ((getFrequentFlyersSinceRP() <= getFrequentFlyerMax())
				|| getRegularPassengerQueue().isEmpty())) {
			// Serve the next frequent flyer.
			setFrequentFlyersSinceRP(getFrequentFlyersSinceRP() + 1);
			setTimeDone(getFrequentFlyerQueue().update(getClock(), isShowAll()));
		} else if (!getRegularPassengerQueue().isEmpty()) {
			// Serve the next regular passenger.
			setFrequentFlyersSinceRP(0);
			setTimeDone(getFrequentFlyerQueue().update(getClock(), isShowAll()));
		} else if (isShowAll()) {
			System.out.println("Time is " + getClock()
					+ " server is idle");

		}
	}

	private void showStats() {
		System.out.println
				("\nThe number of regular passengers served was "
						+ getRegularPassengerQueue().getNumServed());
		double averageWaitingTime =
				(double) getRegularPassengerQueue().getTotalWait()
						/ (double) getRegularPassengerQueue().getNumServed();
		System.out.println(" with an average waiting time of "

				+ averageWaitingTime);

		System.out.println("The number of frequent flyers served was "
				+ getFrequentFlyerQueue().getNumServed());

		averageWaitingTime =

				(double) getFrequentFlyerQueue().getTotalWait()
						/ (double) getFrequentFlyerQueue().getNumServed();
		System.out.println(" with an average waiting time of "

				+ averageWaitingTime);

		System.out.println("Passengers in frequent flyer queue: "
				+ getFrequentFlyerQueue().size());

		System.out.println("Passengers in regular passenger queue: "
				+ getRegularPassengerQueue().size());

	}

	public void enterData(){
		Scanner in = new Scanner(System.in);
		//user set the frequentFlyerMax and maxProcessingTime variables to change simulation.
		System.out.println("Enter the value for Maximum number of frequent flyers to be served\n" +
				"before a regular passenger gets served: ");
		setFrequentFlyerMax(in.nextInt());
		System.out.println("Enter the maximum time to service a passenger: ");
		setMaxProcessingTime(in.nextInt());
		System.out.println("Enter the arrival rate of each regular passenger in minutes. Specify " +
			"a double value: ");
		getRegularPassengerQueue().setArrivalRate(in.nextDouble());
		System.out.println("Enter the arrival rate of each frequent flyer in minutes. Specify " +
				"a double value: ");
		getFrequentFlyerQueue().setArrivalRate(in.nextDouble());
		System.out.println("Enter the total time you wish to simulate in minutes: ");
		setTotalTime(in.nextInt());
	}

	public static void main(String[] args) {
		AirlineCheckinSim sim = new AirlineCheckinSim();
		System.out.println("Running Airline Check-In Simulation.\n");
		sim.enterData();
		sim.runSimulation();
		sim.showStats();
		System.exit(0);
	}
}