package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/
public class Asteroid_Collision {
	public static void main(String[] args) {
		int[] asteroids = {5, 10, -5};
		int[] result = asteroidCollision(asteroids);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		
		for (int asteroid : asteroids) {
			if (asteroid > 0) {
				stack.push(asteroid);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
					stack.pop();
				}
				
				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroid);
				}
				
				if (stack.peek() == Math.abs(asteroid)) {
					stack.pop();
				}
			}
		}
		
		int[] result = new int[stack.size()];
		
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		
		return result;
	}
}