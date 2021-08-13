package Programmers.Practice.Level2;

// JadenCase 문자열 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12951
public class Problem_12951 {
	
	public static void main(String[] args) {
		//String s = "3people unFollowed me";
		//String s = "for the last week";
		String s = "  a  sb ";
		
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		StringBuffer sb = new StringBuffer();
		int pointer = 0;
		
		s = s.toLowerCase();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c >= 'a' && c <= 'z' && pointer == 0) {
				sb.append(Character.toUpperCase(c));
			} else if (c == ' ') {
				sb.append(c);
				pointer = 0;
			} else {
				sb.append(c);
			}
			
			if (c != ' ') {
				pointer++;
			}
		}
		
		return sb.toString();
	}
}