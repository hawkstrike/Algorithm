package Programmers.Practice.Level1;

// 핸드폰 번호 가리기
// https://programmers.co.kr/learn/courses/30/lessons/12948
public class Problem_12948 {
	
	public static void main(String[] args) {
		String phone_number = "01033334444";
		
		System.out.println(solution(phone_number));
	}
	
	public static String solution(String phone_number) {
		StringBuffer sb = new StringBuffer();
		int length = phone_number.length() - 4;
		
		for (int i = 0; i < length; i++) {
			sb.append("*");
		}
		
		sb.append(phone_number.substring(length, length + 4));
		
		return sb.toString();
	}
}