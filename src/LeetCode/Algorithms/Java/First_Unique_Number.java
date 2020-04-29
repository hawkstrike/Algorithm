package LeetCode.Algorithms.Java;

import java.util.LinkedHashSet;

// https://leetcode.com/problems/first-unique-number/
public class First_Unique_Number {
	public static class FirstUnique {
		private LinkedHashSet<Integer> uniqueSet = new LinkedHashSet<>();
		private LinkedHashSet<Integer> noUniqueSet = new LinkedHashSet<>();
		
		public FirstUnique(int[] nums) {
			for (int n : nums) {
				this.add(n);
			}
		}
		
		public int showFirstUnique() {
			try {
				return uniqueSet.iterator().next();
			} catch (Exception e) {
				return -1;
			}
		}
		
		public void add(int value) {
			if (noUniqueSet.contains(value)) {
				return;
			} else if (uniqueSet.contains(value)) {
				uniqueSet.remove(value);
				noUniqueSet.add(value);
			} else {
				uniqueSet.add(value);
			}
		}
	}
	public static void main(String[] args) {
		FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
		
		System.out.println(firstUnique.showFirstUnique());
		firstUnique.add(5);
		System.out.println(firstUnique.showFirstUnique());
		firstUnique.add(2);
		System.out.println(firstUnique.showFirstUnique());
		firstUnique.add(3);
		System.out.println(firstUnique.showFirstUnique());
	}
}