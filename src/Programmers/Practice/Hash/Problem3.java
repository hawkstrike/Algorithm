package Programmers.Practice.Hash;

import java.util.HashMap;

public class Problem3 {
	
	public static void main(String[] args) {
		/*String[][] clothes = {{"yellowhat", "headgear"},
							{"bluesunglasses", "eyewear"},
							{"green_turban", "headgear"}};*/
		String[][] clothes = {{"crowmask", "face"},
							{"bluesunglasses", "face"},
							{"smoky_makeup", "face"}};
		
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		for (String[] clothe : clothes) {
			hashMap.put(clothe[1], hashMap.getOrDefault(clothe[1], 0) + 1);
		}
		
		int multi = 1;
		
		for (int n : hashMap.values()) {
			multi *= n + 1;
		}
		
		return (hashMap.size() == 1) ? clothes.length : multi - 1;
	}
}