package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/
public class Online_Stock_Span {
	public static class StockSpanner {
		Stack<int[]> stack;
		
		public StockSpanner() {
			stack = new Stack<>();
		}
		
		public int next(int price) {
			int span = 1;
			
			while (!stack.isEmpty() && stack.peek()[0] <= price) {
				int[] popArr = stack.pop();
				
				span += popArr[1];
			}
			
			stack.push(new int[]{price, span});
			
			return span;
		}
	}
	public static void main(String[] args) {
		StockSpanner stockSpanner = new StockSpanner();
		
		System.out.println(stockSpanner.next(100));
		System.out.println(stockSpanner.next(80));
		System.out.println(stockSpanner.next(60));
		System.out.println(stockSpanner.next(70));
		System.out.println(stockSpanner.next(60));
		System.out.println(stockSpanner.next(75));
		System.out.println(stockSpanner.next(85));
	}
}