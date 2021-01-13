package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
public class Boats_to_Save_People {
	public static void main(String[] args) {
		int[] people = {1, 2};
		int limit = 3;
		
		System.out.println(numRescueBoats(people, limit));
	}
	
	public static int numRescueBoats(int[] people, int limit) {
		int i = 0;
		int j = people.length - 1;
		int result = 0;
		
		Arrays.sort(people);
		
		while (i <= j) {
			result++;
			
			if (people[i] + people[j] <= limit) {
				i++;
			}
			
			j--;
		}
		
		return result;
	}
}