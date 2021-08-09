package Programmers.SkillCheck.Java;

import java.util.Arrays;
import java.util.List;

public class Level1_1 {
	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("AB", "z", "a B z");
		List<Integer> pushList = Arrays.asList(1, 1, 4);
		
		for (int i = 0; i < stringList.size(); i++) {
			System.out.println(solution(stringList.get(i), pushList.get(i)));
		}
	}
	
	public static String solution(String s, int n) {
		StringBuffer answer = new StringBuffer();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			boolean lowerCaseFlag = (c >= 'a' && c <= 'z') ? true : false;
			
			if (c != ' ') {
				c += n;
				
				if (lowerCaseFlag && c > 'z') {
					c = (char) ((c - 'z') + 'a' - 1);
				} else if(!lowerCaseFlag && c > 'Z') {
					c = (char) ((c - 'Z') + 'A' - 1);
				}
			}
			
			answer.append(c);
		}
		
		return answer.toString();
	}
}