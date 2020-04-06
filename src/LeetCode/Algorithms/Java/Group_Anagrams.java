package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/group-anagrams/
public class Group_Anagrams {
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(strs);
		
		for (List<String> list : result) {
			System.out.println(list.toArray());
		}
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<>();
		}
		
		HashMap<String, List> hashMap = new HashMap<>();
		int[] count = new int[26];
		
		for (String s : strs) {
			Arrays.fill(count, 0);
			
			for (char c : s.toCharArray()) {
				count[c - 'a']++;
			}
			
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < count.length; i++) {
				sb.append("#");
				sb.append(count[i]);
			}
			
			String key = sb.toString();
			
			if (!hashMap.containsKey(key)) {
				hashMap.put(key, new ArrayList());
			}
			
			hashMap.get(key).add(s);
		}
		
		return new ArrayList(hashMap.values());
		
		/*HashMap<String, List> hashMap = new HashMap<>();
		
		for (String s : strs) {
			char[] cArr = s.toCharArray();
			
			Arrays.sort(cArr);
			
			String key = String.valueOf(cArr);
			
			if (!hashMap.containsKey(key)) {
				hashMap.put(key, new ArrayList());
			}
			
			hashMap.get(key).add(s);
		}
		
		return new ArrayList(hashMap.values());*/
	}
}