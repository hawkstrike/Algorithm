package Programmers.Practice.Hash;

import java.util.HashSet;
import java.util.List;

public class Problem2 {
	
	public static void main(String[] args) {
		//String[] phone_book = {"119", "97674223", "1195524421"};
		//String[] phone_book = {"123", "456", "789"};
		String[] phone_book = {"12", "123", "1235", "567", "88"};
		
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
		HashSet<String> hashSet = new HashSet<>(List.of(phone_book));
		
		for (String key : hashSet) {
			for (int i = 1; i < key.length(); i++) {
				if (hashSet.contains(key.substring(0, i))) {
					return false;
				}
			}
		}
		
		return true;
	}
}