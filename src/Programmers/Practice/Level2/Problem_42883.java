package Programmers.Practice.Level2;

// 큰 수 만들기
// https://programmers.co.kr/learn/courses/30/lessons/42883
public class Problem_42883 {
	private static int max;
	
	public static void main(String[] args) {
		/*String number = "1924";
		int k = 2;*/
		/*String number = "1231234";
		int k = 3;*/
		String number = "4177252841";
		int k = 4;
		/*String number = "123";
		int k = 2;*/
		
		System.out.println(solution(number, k));
	}
	
	public static String solution(String number, int k) {
		StringBuffer sb = new StringBuffer();
		int index = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < number.length() - k; i++) {
			max = Integer.MIN_VALUE;
			
			for (int j = index; j <= i + k; j++) {
				int compare = number.charAt(j) - '0';
				
				if (max < compare) {
					max = compare;
					index = j + 1;
				}
			}
			
			sb.append(max);
		}
		
		return sb.toString();
	}
}