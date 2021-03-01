package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/distribute-candies/
public class Distribute_Candies {
	public static void main(String[] args) {
		int[] candyType = {1, 1, 2, 2, 3, 3};
		
		System.out.println(distributeCandies(candyType));
	}
	
	public static int distributeCandies(int[] candyType) {
		HashSet<Integer> hashSet = new HashSet<>();
		
		for (int candy : candyType) {
			hashSet.add(candy);
		}
		
		return Math.min(hashSet.size(), candyType.length / 2);
	}
}