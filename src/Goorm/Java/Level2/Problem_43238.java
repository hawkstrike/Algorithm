package Goorm.Java.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://level.goorm.io/exam/43238/%EC%86%8C%EC%88%98-%ED%8C%90%EB%B3%84/quiz/1
public class Problem_43238 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String trueStr = "True";
		String falseStr = "False";
		
		if (n % 2 == 0 || n <= 1) {
			System.out.println((n == 2) ? trueStr : falseStr);
		} else {
			for (int i = 3; i <= Math.sqrt(n); i += 2) {
				if (n % i == 0) {
					System.out.println(falseStr);
					return;
				}
			}
			
			System.out.println(trueStr);
		}
		
		br.close();
	}
}