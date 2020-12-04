package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/the-kth-factor-of-n/
public class The_kth_Factor_of_n {
	public static void main(String[] args) {
		/*int n = 12;
		int k = 3;*/
		/*int n = 7;
		int k = 2;*/
		/*int n = 4;
		int k = 4;*/
		/*int n = 1;
		int k = 1;*/
		/*int n = 1000;
		int k = 3;*/
		int n = 24;
		int k = 6;
		
		System.out.println(kthFactor(n, k));
	}
	
	public static int kthFactor(int n, int k) {
		List<Integer> list = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			int rest = n % i;
			
			if (rest == 0) {
				list.add(i);
			}
		}
		
		if (list.size() < k) {
			return -1;
		} else {
			return list.get(k - 1);
		}
	}
}