package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class First_Unique_Character_in_a_String {
	public static void main(String[] args) {
		String s = "loveleetcode"; // "leetcode";
		
		System.out.println(firstUniqChar(s));
	}
	
	public static int firstUniqChar(String s) {
		int[] alphabetArr = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			alphabetArr[s.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (alphabetArr[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		
		/*HashMap<Character, Integer> hashMap = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (!hashMap.containsKey(c)) {
				hashMap.put(c, 1);
			} else {
				hashMap.put(c, hashMap.get(c) + 1);
			}
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (hashMap.get(s.charAt(i)) == 1) {
				return i;
			}
		}*/
		
		return -1;
	}
}