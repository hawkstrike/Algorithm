package Goorm.Java.Level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://level.goorm.io/exam/49095/%EA%B3%A0%EC%9E%A5%EB%82%9C-%EC%BB%B4%ED%93%A8%ED%84%B0/quiz/1
public class Problem_49095 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] infoArr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(info -> Integer.parseInt(info))
				.toArray();
		int n = infoArr[0];
		int c = infoArr[1];
		int[] codeArr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(time -> Integer.parseInt(time))
				.toArray();
		int count = 1;
		
		for (int i = 1; i < n; i++) {
			count++;
			
			if (codeArr[i] - codeArr[i - 1] > c) {
				count = 1;
			}
		}
		
		System.out.println(count);
	}
}