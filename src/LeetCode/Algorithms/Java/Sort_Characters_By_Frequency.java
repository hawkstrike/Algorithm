package LeetCode.Algorithms.Java;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/sort-characters-by-frequency/
public class Sort_Characters_By_Frequency {
	public static void main(String[] args) {
		String s = "tree";
		
		System.out.println(frequencySort(s));
	}
	
	public static String frequencySort(String s) {
		HashMap<Character, Integer> hashMap = new HashMap<>();
		
		for (char c : s.toCharArray()) {
			hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
		}
		
		ArrayList<Character> list = new ArrayList<>(hashMap.keySet());
		Collections.sort(list, new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return hashMap.get(o2).compareTo(hashMap.get(o1));
			}
		});
		
		StringBuffer sb = new StringBuffer();
		
		for (char c : list) {
			for (int i = 0; i < hashMap.get(c); i++) {
				sb.append(c);
			}
		}
		
		return sb.toString();
		
		/*return s.chars()
				.mapToObj(Character::toString)                        //map to string character
				.collect(Collectors.groupingBy(Function.identity()))  //collect to Map<String, List<String>>
				.values()                                             //drop keys, we care only about values
				.stream()
				.sorted(Comparator.<List<String>>comparingInt(List::size).reversed()) //sort by list size in descending order
				.flatMap(strings -> strings.stream())                                 //flat map to stream of character strings
				.collect(Collectors.joining());                                       //build a string from the stream*/
		
		//Stream<Map.Entry<Character, Integer>> stream = hashMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
	}
}