package Goorm.Java.LevelTest.SelfLevelTest1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://level.goorm.io/exam/49912/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%96%B4%EB%A1%9C%EC%A6%88-%EC%85%80%ED%94%84%EB%A0%88%EB%B2%A8%ED%85%8C%EC%8A%A4%ED%8A%B8-1%EC%B0%A8/quiz/2
public class Problem2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			int sqrtNum = (int) Math.sqrt(num);
			
			if (sqrtNum * sqrtNum == num) {
				count++;
			}
		}
		
		System.out.println(count);
		
		br.close();
	}
}