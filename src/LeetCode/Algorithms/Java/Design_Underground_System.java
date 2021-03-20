package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/design-underground-system/
public class Design_Underground_System {
	public static class UndergroundSystem {
		private HashMap<Integer, String> checkInStatus;
		private HashMap<Integer, Integer> checkInTime;
		private HashMap<String, Integer> totalTime;
		private HashMap<String, Integer> count;
		
		public UndergroundSystem() {
			checkInStatus = new HashMap<>();
			checkInTime = new HashMap<>();
			totalTime = new HashMap<>();
			count = new HashMap<>();
		}
		
		public void checkIn(int id, String stationName, int t) {
			checkInStatus.put(id, stationName);
			checkInTime.put(id, t);
		}
		
		public void checkOut(int id, String stationName, int t) {
			String key = checkInStatus.get(id) + ":" + stationName;
			
			totalTime.put(key, (t - checkInTime.get(id)) + totalTime.getOrDefault(key, 0));
			count.put(key, count.getOrDefault(key, 0) + 1);
		}
		
		public double getAverageTime(String startStation, String endStation) {
			String key = startStation + ":" + endStation;
			
			return (totalTime.containsKey(key)) ? (double) totalTime.get(key) / count.get(key) : 0;
		}
	}
	
	public static void main(String[] args) {
		UndergroundSystem undergroundSystem = new UndergroundSystem();
		
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		undergroundSystem.checkOut(45, "Waterloo", 15);
		undergroundSystem.checkOut(32, "Cambridge", 22);
		System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
		undergroundSystem.checkIn(10, "Leyton", 24);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
	}
}