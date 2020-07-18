package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule-ii/
public class Course_Schedule_II {
	public static void main(String[] args) {
		/*int n = 2;
		int[][] prerequisites = {{1, 0}};*/
		/*int n = 4;
		int[][] prerequisites = {{1, 0},
								{2, 0},
								{3, 1},
								{3, 2}};*/
		int n = 3;
		int[][] prerequisites = {{1, 0},
								{1, 2},
								{0, 1}};
		int[] result = findOrder(n, prerequisites);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> graphList = new ArrayList<>();
		int[] edgeArr = new int[numCourses];
		
		for (int i = 0; i < numCourses; i++) {
			graphList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < prerequisites.length; i++) {
			graphList.get(prerequisites[i][1]).add(prerequisites[i][0]);
			edgeArr[prerequisites[i][0]]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < numCourses; i++) {
			if (edgeArr[i] == 0) {
				q.offer(i);
				result.add(i);
			}
		}
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int edge : graphList.get(curr)) {
				edgeArr[edge]--;
				
				if (edgeArr[edge] == 0) {
					q.offer(edge);
					result.add(edge);
				}
			}
		}
		
		return (result.size() == numCourses) ? result.stream().mapToInt(i -> i).toArray() : new int[0];
	}
}