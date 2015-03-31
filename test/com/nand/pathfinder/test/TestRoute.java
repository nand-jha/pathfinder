package com.nand.pathfinder.test;

import java.util.ArrayList;
import java.util.List;

import com.nand.pathfinder.bag.Bag;
import com.nand.pathfinder.flight.Flight;
import com.nand.pathfinder.flight.FlightList;
import com.nand.pathfinder.route.RouteMap;

/**
 * This is test class for the application
 * This test case will generate test data (Flight details, Route details and Bag details)
 * and will print out put in ystem console for each bag.
 * @author Nandj
 *
 */
public class TestRoute {

	private List<Bag> bagList;
	public static void main(String [] args){
		TestRoute test = new TestRoute();
		test.generateRouteMap();
		test.geterateFlightList();
		test.generateBagList();
		
		for (Bag bag : test.bagList){
			System.out.println(bag.getId()+" "+bag.getRoute().pathDetails());
		}
	}
	
	/**
	 * Generate Flight list data
	 */
	private void geterateFlightList(){
		Flight flight1 = new Flight("UA10","A1","MIA","08:00");
		Flight flight2 = new Flight("UA11","A1","LAX","09:00");
		Flight flight3 = new Flight("UA12","A1","JFK","09:45");
		Flight flight4 = new Flight("UA13","A2","JFK","08:30");
		Flight flight5 = new Flight("UA14","A2","JFK","09:45");
		Flight flight6 = new Flight("UA15","A2","JFK","10:00");
		Flight flight7 = new Flight("UA16","A3","JFK","09:00");
		Flight flight8 = new Flight("UA17","A4","MHT","09:15");
		Flight flight9 = new Flight("UA18","A5","LAX","10:15");
		
		FlightList.getInstance().addFlight(flight1);
		FlightList.getInstance().addFlight(flight2);
		FlightList.getInstance().addFlight(flight3);
		FlightList.getInstance().addFlight(flight4);
		FlightList.getInstance().addFlight(flight5);
		FlightList.getInstance().addFlight(flight6);
		FlightList.getInstance().addFlight(flight7);
		FlightList.getInstance().addFlight(flight8);
		FlightList.getInstance().addFlight(flight9);
	}
	
	/**
	 * generate Route map, list of connecting nodes and travel duration
	 */
	private void generateRouteMap(){
		RouteMap routeMap = RouteMap.getInstance();
		
		routeMap.addRoute("Concourse_A_Ticketing","A5",5);
		routeMap.addRoute("A5","BaggageClaim",5);
		routeMap.addRoute("A5","A10",4);
		routeMap.addRoute("A5","A1",6);
		routeMap.addRoute("A1","A2",1);
		routeMap.addRoute("A2","A3",1);
		routeMap.addRoute("A3","A4",1);
		routeMap.addRoute("A10","A9",1);
		routeMap.addRoute("A9","A8",1);
		routeMap.addRoute("A8","A7",1);
		routeMap.addRoute("A7","A6",1);
	}
	
	/**
	 * Generates bag list
	 */
	private void generateBagList(){
		bagList = new ArrayList<Bag>();
		
		Bag bag1 = new Bag("0001", "Concourse_A_Ticketing", "UA12");
		Bag bag2 = new Bag("0002", "A5", "UA17");
		Bag bag3 = new Bag("0003", "A2", "UA10");
		Bag bag4 = new Bag("0004", "A8", "UA18");
		Bag bag5 = new Bag("0005", "A7", "ARRIVAL");
		bagList.add(bag1);
		bagList.add(bag2);
		bagList.add(bag3);
		bagList.add(bag4);
		bagList.add(bag5);
	}
	
}
