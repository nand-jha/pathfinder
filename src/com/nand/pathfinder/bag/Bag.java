package com.nand.pathfinder.bag;

import com.nand.pathfinder.route.RouteDetails;
import com.nand.pathfinder.route.RouteMap;

/**
 * Bean to define Bag
 * @author nandj
 *
 */
public class Bag {

	private String id;
	private String entryPoint;
	private String flightId;//ARRIVAL a separate case
	private String destination;
	
	/**
	 * 
	 * @param id
	 * @param entryPoint
	 * @param flightId
	 */
	public Bag(String id, String entryPoint, String flightId) {
		this.id = id;
		this.entryPoint = entryPoint;
		this.flightId = flightId;
	}

	/**
	 * 
	 * @return RouteDetails of current Bag
	 */
	public RouteDetails getRoute(){
		return RouteMap.getInstance().findOptimalRoute(this);
	}

	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @return the entryPoint
	 */
	public String getEntryPoint() {
		return entryPoint;
	}


	/**
	 * @return the flightId
	 */
	public String getFlightId() {
		return flightId;
	}


	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bag [id=" + id + ", entryPoint=" + entryPoint + ", flightId="
				+ flightId + "]";
	}
	
	
}
