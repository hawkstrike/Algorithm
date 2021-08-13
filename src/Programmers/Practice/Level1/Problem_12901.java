package Programmers.Practice.Level1;

// 2016년
// https://programmers.co.kr/learn/courses/30/lessons/12901
public class Problem_12901 {
	
	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		
		System.out.println(solution(a, b));
	}
	
	public static String solution(int a, int b) {
		String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int day = b - 1;
		
		for (int i = 0; i < a - 1; i++) {
			day += days[i];
		}
		
		return dayOfWeek[day % 7];
	}
}