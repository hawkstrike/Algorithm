package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/keys-and-rooms/
public class Keys_and_Rooms {
	public static void main(String[] args) {
		List<List<Integer>> rooms = new LinkedList<>();
		
		/*rooms.add(Arrays.asList(new Integer[]{1}));
		rooms.add(Arrays.asList(new Integer[]{2}));
		rooms.add(Arrays.asList(new Integer[]{3}));
		rooms.add(new LinkedList<>());*/
		rooms.add(Arrays.asList(new Integer[]{1, 3}));
		rooms.add(Arrays.asList(new Integer[]{3, 0, 1}));
		rooms.add(Arrays.asList(new Integer[]{2}));
		rooms.add(Arrays.asList(new Integer[]{0}));
		
		System.out.println(canVisitAllRooms(rooms));
	}
	
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int length = rooms.size();
		boolean[] visited = new boolean[length];
		
		recurrentCanVisitAllRooms(rooms, visited, 0);
		
		for (boolean flag : visited) {
			if (!flag) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void recurrentCanVisitAllRooms(List<List<Integer>> rooms, boolean[] visited, int index) {
		List<Integer> list = rooms.get(index);
		visited[index] = true;
		
		if (index > rooms.size() || rooms.get(index).size() == 0) {
			return;
		}
		
		for (int key : list) {
			if (!visited[key]) {
				recurrentCanVisitAllRooms(rooms, visited, key);
			}
		}
	}
}