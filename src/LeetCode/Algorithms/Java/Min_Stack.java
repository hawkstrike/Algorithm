package LeetCode.Algorithms.Java;

import java.util.LinkedList;

// https://leetcode.com/problems/min-stack/
public class Min_Stack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}

	static class MinStack {
		private long min;
		LinkedList<Long> stack;
		
		public MinStack() {
			stack = new LinkedList<>();
		}
		
		public void push(int x) {
			if (stack.isEmpty()) {
				stack.push(0L);
				this.min = x;
			} else {
				stack.push(x - this.min);
				
				if (x < this.min) {
					this.min = x;
				}
			}
		}
		
		public void pop() {
			if (stack.isEmpty()) {
				return;
			}
			
			long pop = stack.pop();
			
			if (pop < 0) {
				this.min -= pop;
			}
		}
		
		public int top() {
			long top = stack.peek();
			
			if (top > 0) {
				return (int) (top + this.min);
			} else {
				return (int) this.min;
			}
		}
		
		public int getMin() {
			return (int) this.min;
		}
	}
}