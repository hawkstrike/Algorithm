package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/iterator-for-combination/
public class Iterator_for_Combination {
	public static class CombinationIterator {
		List<String> list = new ArrayList<>();
		String characters = null;
		int combinationLength = 0;
		int index = 0;
		
		public CombinationIterator(String characters, int combinationLength) {
			this.characters = characters;
			this.combinationLength = combinationLength;
			
			backTracking(new StringBuffer(), 0);
		}
		
		public String next() {
			return this.list.get(this.index++);
		}
		
		public boolean hasNext() {
			return this.index < this.list.size();
		}
		
		private void backTracking(StringBuffer sb, int index) {
			if (sb.length() == this.combinationLength) {
				this.list.add(sb.toString());
				
				return;
			}
			
			int size = sb.length();
			
			for (int i = index; i < this.characters.length(); i++) {
				backTracking(sb.append(this.characters.charAt(i)), i + 1);
				sb.delete(size, sb.length());
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
		
		System.out.println(combinationIterator.next());
		System.out.println(combinationIterator.hasNext());
		System.out.println(combinationIterator.next());
		System.out.println(combinationIterator.hasNext());
		System.out.println(combinationIterator.next());
		System.out.println(combinationIterator.hasNext());
	}
}