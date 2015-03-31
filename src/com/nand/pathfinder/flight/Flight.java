package com.nand.pathfinder.flight;

/**
 * Bean to define Flight
 * @author nandj
 *
 */
public class Flight {

	private String flightId;
	private String flightGate;
	private String destination;
	private String flightTime;

	/**
	 * 
	 * @param flightId
	 * @param flightGate
	 * @param destination
	 * @param flightTime
	 */
	public Flight(String flightId, String flightGate, String destination,
			String flightTime) {
		this.flightId = flightId;
		this.flightGate = flightGate;
		this.destination = destination;
		this.flightTime = flightTime;
	}
	
	

	public Flight(String flightId) {
		this.flightId = flightId;
	}


	

	/**
	 * @return the flightId
	 */
	public String getFlightId() {
		return flightId;
	}



	/**
	 * @return the flightGate
	 */
	public String getFlightGate() {
		return flightGate;
	}



	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}



	/**
	 * @return the flightTime
	 */
	public String getFlightTime() {
		return flightTime;
	}



	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightGate=" + flightGate
				+ ", destination=" + destination + ", flightTime=" + flightTime
				+ "]";
	}



	/* 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result
				+ ((flightGate == null) ? 0 : flightGate.hashCode());
		result = prime * result
				+ ((flightId == null) ? 0 : flightId.hashCode());
		result = prime * result
				+ ((flightTime == null) ? 0 : flightTime.hashCode());
		return result;
	}



	/* 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		return true;
	}
	
}
