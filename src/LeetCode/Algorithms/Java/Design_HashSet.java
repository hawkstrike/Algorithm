package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/add-binary/
public class Design_HashSet {
	public static class MyHashSet {
		boolean[] arr = new boolean[1000000];
		
		public MyHashSet() {
		}
		
		public void add(int key) {
			if (key > 0 && key <= arr.length) {
				if (!arr[key - 1]) {
					arr[key - 1] = true;
				}
			}
		}
		
		public void remove(int key) {
			if (key > 0 && key <= arr.length) {
				if (arr[key - 1]) {
					arr[key - 1] = false;
				}
			}
		}
		
		public boolean contains(int key) {
			return (key > 0 && key <= arr.length) ? arr[key - 1] : false;
		}
	}
	/*public static class MyHashSet {
		List<Integer> list = null;
		
		public MyHashSet() {
			list = new LinkedList<>();
		}
		
		public void add(int key) {
			if (!list.contains(key)) {
				list.add(key);
			}
		}
		
		public void remove(int key) {
			if (list.contains(key)) {
				for (int i = 0; i < list.size(); i++) {
					if (key == list.get(i)) {
						list.remove(i);
						return;
					}
				}
			}
		}
		
		public boolean contains(int key) {
			return list.contains(key);
		}
	}*/
	
	public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		
		myHashSet.add(1);
		myHashSet.add(2);
		System.out.println(myHashSet.contains(1));
		System.out.println(myHashSet.contains(3));
		myHashSet.add(2);
		System.out.println(myHashSet.contains(2));
		myHashSet.remove(2);
		System.out.println(myHashSet.contains(2));
	}
}