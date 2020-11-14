package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/poor-pigs/
public class Poor_Pigs {
	public static void main(String[] args) {
		int buckets = 1000;
		int minutesToDie = 15;
		int minutesToTest = 60;
		
		System.out.println(poorPigs(buckets, minutesToDie, minutesToTest));
	}
	
	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		return (int) Math.ceil(Math.log(buckets) / Math.log((minutesToTest / minutesToDie) + 1));
	}
}