package com.nand.pathfinder.flight;

import java.util.Map;
import java.util.TreeMap;

/**
 * Singleton class to have list of flights
 * @author nandj
 *
 */
public class FlightList {

	private static final FlightList flightList = new FlightList();
	private FlightList(){}
	
	/*
	 * Map to contain list of Flight
	 */
	private Map<String,Flight> flightMap = new TreeMap<String,Flight>();
	
	/**
	 * 
	 * @return Singleton instance of FlightList object
	 */
	public static FlightList getInstance(){
		return flightList;
	}

	/**
	 * 
	 * @param flightId
	 * @return Flight from List of Flight
	 */
	public Flight getFlight(String flightId) {
		return flightMap.get(flightId);
	}
	
	/**
	 * Add a Flight to FlightList
	 * @param flight
	 */
	public void addFlight(Flight flight){
		flightMap.put(flight.getFlightId(),flight);
	}
	
}
