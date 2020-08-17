package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/distribute-candies-to-people/
public class Distribute_Candies_to_People {
	public static void main(String[] args) {
		//int candies = 7;
		//int num_people = 4;
		int candies = 10;
		int num_people = 3;
		int[] result = distributeCandies(candies, num_people);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] distributeCandies(int candies, int num_people) {
		int[] result = new int[num_people];
		int index = 0;
		int candy = 1;
		
		while (candies > 0) {
			result[index] += Math.min(candies, candy);
			
			index = (index == num_people - 1) ? 0 : index + 1;
			candies -= candy++;
		}
		
		return result;
	}
}