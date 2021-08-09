package Programmers.SkillCheck.Java;

import java.util.Arrays;

public class Level1_2 {
	
	public static void main(String[] args) {
		String s = "Zbcdefg";
		
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		StringBuffer answer = new StringBuffer();
		char[] arr = s.toCharArray();
		
		Arrays.sort(arr);
		answer.append(arr);
		
		return answer.reverse().toString();
	}
}