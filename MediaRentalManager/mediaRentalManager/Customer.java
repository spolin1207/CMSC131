package mediaRentalManager;

import java.util.ArrayList;

/**
 * Class that holds specific information about the customers
 * One of four classes that that supports MediaRentalManager
 * @author Sujay Polineni
 *
 */

public class Customer {	
	
	/**
	 * Initializes variables that pertain to the customer
	 * Creates rented and queue ArrayList
	 */
	
	private String name;
	private String address;
	private String plan;
	
	private static int planLimit = 2;
	
	private ArrayList<String> rented = new ArrayList<String>();
	private ArrayList<String> queue = new ArrayList<String>();
	
	/**
	 * Returns the plan limit
	 * @return
	 */
	public static int getPlanLimit() {
		return planLimit;
	}
	
	/**
	 * Sets plan limit
	 * @param planLimit
	 */
	public static void setPlanLimit(int planLimit) {
		Customer.planLimit = planLimit;
		}
	
	/**
	 * Initializes variables
	 * @param name
	 * @param address
	 * @param plan
	 */
	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
	}
	
	/**
	 * Adds titles of media to the rented ArrayList
	 * @param title
	 */
	public void addRented(String title) {
		rented.add(title);
	}
	
	/**
	 * Removes titles of media from the rented ArrayList
	 * @param title
	 */
	public void removeRented(String title) {
		rented.remove(title);
	}
	
	/**
	 * Adds titles of media to the queue ArrayList
	 * @param title
	 */
	public void addQueue(String title) {
		queue.add(title);
	}
	
	/**
	 * Removes titles of media from the queue ArrayList
	 * @param title
	 */
	public void removeQueue(String title) {
		queue.remove(title);
	}
	
	/**
	 * Returns the rented ArrayList
	 * @return
	 */
	public ArrayList<String> getRented() {
		return rented;
	}

	/**
	 * Sets the rented ArrayList
	 * @param rented
	 */
	public void setRented(ArrayList<String> rented) {
		this.rented = rented;
	}

	/**
	 * Returns the queue ArrayList
	 * @return
	 */
	public ArrayList<String> getQueue() {
		return queue;
	}

	/**
	 * Sets the queue ArrayList
	 * @param queue
	 */
	public void setQueue(ArrayList<String> queue) {
		this.queue = queue;
	}
	
	/**
	 * toString method that will be returned as output
	 */
	@Override
	public String toString() {
		return "Name: " + name + ", Address: " + address + ", Plan: " + plan + "\n" + "Rented: " + rented + "\n" +  "Queue: " + queue;
	}

	/**
	 * Returns the name parameter
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name parameter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the address parameter
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address parameter
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the plan parameter
	 * @return
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * Sets the plan parameter
	 * @param plan
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}
}
