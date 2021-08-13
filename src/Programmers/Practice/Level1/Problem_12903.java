package Programmers.Practice.Level1;

// 가운데 글자 가져오기
// https://programmers.co.kr/learn/courses/30/lessons/12903
public class Problem_12903 {
	
	public static void main(String[] args) {
		//String s = "abcde";
		String s = "qwer";
		
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		int length = s.length();
		int midLength = length / 2;
		
		return (length % 2 == 0) ? s.substring(midLength - 1, midLength + 1) : s.substring(midLength, midLength + 1);
	}
}