package com.nand.pathfinder.route;

import com.nand.pathfinder.bag.Bag;
import com.nand.pathfinder.flight.Flight;
import com.nand.pathfinder.flight.FlightList;

import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.model.problem.SearchProblem;
import es.usc.citius.hipster.util.graph.GraphSearchProblem;
import es.usc.citius.hipster.util.graph.HashBasedHipsterGraph;

/**
 * This class keeps track of all possible routes along with travelDuration.
 * Provide optimal Route between two Nodes.
 * @author nandj
 *
 */
public class RouteMap {
	
	private static final RouteMap routeMap = new RouteMap();
	// Create Bi-directional map
	private HashBasedHipsterGraph<String,Integer> graph = new HashBasedHipsterGraph<>();
	
	public String BaggageClaim = "BaggageClaim";

	/**
	 * 
	 */
	private RouteMap(){

	}
	
	public static RouteMap getInstance(){
			return routeMap;
	}
	
	
	/**
	 * Add a Route between two Nodes
	 * @param route
	 */
	public void addRoute(String node1, String node2, int tarvelTime){
		graph.connect(node1, node2, tarvelTime);
	}
	
	/**
	 * Provides optimal path between two nodes
	 * @param fromNode
	 * @param toNode
	 * @return RouteDetails
	 */
	public RouteDetails findOptimalRoute(String fromNode, String toNode){
		SearchProblem p = GraphSearchProblem
				  .startingFrom(fromNode)
				  .in(graph)
				  .takeCostsFromEdges()
				  .build();
		return new RouteDetails(Hipster.createDijkstra(p).search(toNode));
	}

	/**
	 * Provides optimal path for a Bag
	 * @param bag
	 * @return RouteDetails
	 */
	public RouteDetails findOptimalRoute(Bag bag) {
		Flight flight = FlightList.getInstance().getFlight(bag.getFlightId());
		if (bag.getFlightId().equals("ARRIVAL")){
			return findOptimalRoute(bag.getEntryPoint(), BaggageClaim);
		} else {
			return findOptimalRoute(bag.getEntryPoint(), flight.getFlightGate());
		}
	}

}
