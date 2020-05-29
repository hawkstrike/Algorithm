package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule/
public class Course_Schedule {
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {{1, 0}};
		
		System.out.println(canFinish(numCourses, prerequisites));
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> graphList = new ArrayList<>();
		int[] edgeArr = new int[numCourses];
		
		for (int i = 0; i < numCourses; i++) {
			graphList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < prerequisites.length; i++) {
			graphList.get(prerequisites[i][0]).add(prerequisites[i][1]);
			edgeArr[prerequisites[i][1]]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < numCourses; i++) {
			if (edgeArr[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int edge : graphList.get(curr)) {
				edgeArr[edge]--;
				
				if (edgeArr[edge] == 0) {
					q.add(edge);
				}
			}
			
			numCourses--;
		}
		
		return numCourses == 0;
	}
}