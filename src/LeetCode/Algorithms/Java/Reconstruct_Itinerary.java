package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/reconstruct-itinerary/
public class Reconstruct_Itinerary {
	public static void main(String[] args) {
		List<List<String>> tickets = new LinkedList<>();
		String[][] ticketArr = {{"MUC", "LHR"},
								{"JFK", "MUC"},
								{"SFO", "SJC"},
								{"LHR", "SFO"}};
		
		for (String[] ticket : ticketArr) {
			tickets.add(Arrays.asList(ticket));
		}
		
		List<String> result = findItinerary(tickets);
		
		for (String ticket : result) {
			System.out.print(ticket + " ");
		}
		System.out.println();
	}
	
	public static List<String> findItinerary(List<List<String>> tickets) {
		if (tickets == null || tickets.isEmpty()) {
			return null;
		}
		
		ArrayList<String> result = new ArrayList<>();
		HashMap<String, List<String>> hashMap = new HashMap<>();
		
		for (List<String> ticket : tickets) {
			if (!hashMap.containsKey(ticket.get(0))) {
				List<String> ticketList = new ArrayList<>();
				
				ticketList.add(ticket.get(1));
				hashMap.put(ticket.get(0), ticketList);
			} else {
				List<String> ticketList = hashMap.get(ticket.get(0));
				
				ticketList.add(ticket.get(1));
				hashMap.put(ticket.get(0), ticketList);
			}
		}
		
		for (List<String> ticket : hashMap.values()) {
			Collections.sort(ticket);
		}
		
		backtracking(result, hashMap, "JFK");
		
		return result;
	}
	
	public static void backtracking(List<String> result, HashMap<String, List<String>> hashMap, String current) {
		while (hashMap.containsKey(current) && !hashMap.get(current).isEmpty()) {
			String ticket = hashMap.get(current).remove(0);
			
			backtracking(result, hashMap, ticket);
		}
		
		result.add(0, current);
	}
}