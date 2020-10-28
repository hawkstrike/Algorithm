package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/
public class Summary_Ranges {
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 4, 5, 7};
		//int[] nums = {0, 2, 3, 4, 6, 8, 9};
		//int[] nums = {0};
		List<String> result = summaryRanges(nums);
		
		for (String str : result) {
			System.out.println(str);
		}
	}
	
	public static List<String> summaryRanges(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new LinkedList<>();
		}
		
		List<String> list = new LinkedList<>();
		int curr = 0;
		
		for (int i = 0; i < nums.length; i++) {
			curr = i;
			
			while (i + 1 < nums.length && (nums[i] + 1) == nums[i + 1]) {
				i++;
			}
			
			list.add(getRange(nums[curr], nums[i]));
		}
		
		return list;
		
		/*List<String> list = new LinkedList<>();
		int from = nums[0];
		int curr = from;
		int to = 0;
		
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			
			if ((curr + 1) == n || curr == n) {
				to = n;
				curr = n;
			} else {
				if (from == curr) {
					list.add(from + "");
				} else {
					list.add(from + "->" + to);
				}
				
				from = n;
				curr = from;
			}
			
			if (i == nums.length - 1) {
				if (from == n) {
					list.add(from + "");
				} else {
					list.add(from + "->" + to);
				}
			}
		}
		
		return list;*/
	}
	
	public static String getRange(int start, int end) {
		StringBuffer sb = new StringBuffer();
		
		if (start == end) {
			sb.append(start);
		} else {
			sb.append(start).append("->").append(end);
		}
		
		return sb.toString();
	}
}