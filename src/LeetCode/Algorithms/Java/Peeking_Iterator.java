package LeetCode.Algorithms.Java;

import java.util.HashSet;
import java.util.Iterator;

// https://leetcode.com/problems/peeking-iterator/
public class Peeking_Iterator {
	public static class PeekingIterator implements Iterator<Integer> {
		Iterator<Integer> iterator = null;
		Integer currInteger = null;
		
		public PeekingIterator(Iterator<Integer> iterator) {
			this.iterator = iterator;
			currInteger = this.iterator.next();
		}
		
		public Integer peek() {
			return this.currInteger;
		}
		
		public Integer next() {
			Integer value = currInteger;
			
			if (this.iterator.hasNext()) {
				this.currInteger = this.iterator.next();
			} else {
				this.currInteger = null;
			}
			
			return value;
		}
		
		public boolean hasNext() {
			return this.currInteger != null;
		}
	}
	
	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<>();
		
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		
		PeekingIterator peekingIterator = new PeekingIterator(hashSet.iterator());
		
		while (peekingIterator.hasNext()) {
			System.out.println(peekingIterator.peek());
			System.out.println(peekingIterator.next());
		}
		System.out.println(peekingIterator.peek());
	}
}