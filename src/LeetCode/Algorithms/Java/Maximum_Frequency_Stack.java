package LeetCode.Algorithms.Java;

import java.util.HashMap;
import java.util.Stack;

// https://leetcode.com/problems/maximum-frequency-stack/
public class Maximum_Frequency_Stack {
	public static class FreqStack {
		HashMap<Integer, Integer> hashMap;
		HashMap<Integer, Stack<Integer>> stackHashMap;
		int maxFreq = 0;
		
		public FreqStack() {
			hashMap = new HashMap<>();
			stackHashMap = new HashMap<>();
		}
		
		public void push(int x) {
			int freq = hashMap.getOrDefault(x, 0) + 1;
			
			hashMap.put(x, freq);
			maxFreq = Math.max(maxFreq, freq);
			stackHashMap.putIfAbsent(freq, new Stack<>());
			stackHashMap.get(freq).add(x);
		}
		
		public int pop() {
			int x = stackHashMap.get(maxFreq).pop();
			
			hashMap.put(x, maxFreq - 1);
			
			if (stackHashMap.get(maxFreq).size() == 0) {
				maxFreq--;
			}
			
			return x;
		}
	}
	
	public static void main(String[] args) {
		FreqStack freqStack = new FreqStack();
		
		freqStack.push(5);
		freqStack.push(7);
		freqStack.push(5);
		freqStack.push(7);
		freqStack.push(4);
		freqStack.push(5);
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
	}
}