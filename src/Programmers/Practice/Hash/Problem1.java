package Programmers.Practice.Hash;

import java.util.HashMap;

public class Problem1 {
	
	public static void main(String[] args) {
		/*String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};*/
		/*String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};*/
		/*String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};*/
		String[] participant = {"apple"};
		String[] completion = {};
		
		System.out.println(solution(participant, completion));
	}
	
	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		for (String person : participant) {
			hashMap.put(person, hashMap.getOrDefault(person, 0) + 1);
		}
		
		for (String person : completion) {
			hashMap.put(person, hashMap.get(person) - 1);
			
			if (hashMap.get(person) == 0) {
				hashMap.remove(person);
			}
		}
		
		return (String) hashMap.keySet().toArray()[0];
	}
}