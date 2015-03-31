package com.nand.pathfinder.route;

import java.util.LinkedList;
import java.util.List;

import es.usc.citius.hipster.algorithm.Algorithm.SearchResult;
import es.usc.citius.hipster.model.impl.WeightedNode;

/**
 * This class wrapper class to have Route output in desired format 
 * @author nandj
 *
 */
public class RouteDetails {

	private SearchResult searchResult;

	/**
	 * 
	 * @param searchResult
	 */
	public RouteDetails(SearchResult searchResult) {
		this.searchResult = searchResult;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String pathDetails (){
		List<LinkedList> optimalPath = searchResult.getOptimalPaths();
		int duration  = ((Double)((WeightedNode)searchResult.getGoalNode()).getScore()).intValue();
		
		return tracePath(optimalPath, duration).toString();
	}
	/**
	 * 
	 * @param optimalPath
	 * @param duration
	 * @return StringBuilder
	 */
	private StringBuilder tracePath(List<LinkedList> optimalPath,int duration){
		StringBuilder builder = new StringBuilder();
		for (Object node: optimalPath.get(0)){
			builder = builder.append(node).append(" ");
		}
		builder.append(": ").append(duration);
		return builder;
	}
}
