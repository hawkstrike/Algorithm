package Goorm.Java.Level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://level.goorm.io/exam/43173/%EB%B9%84%ED%8A%B8%EC%97%B0%EC%82%B0-%EA%B8%B0%EB%B3%B8-2/quiz/1
public class Problem_43173 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		
		System.out.println(a >> b);
		System.out.println(a << b);
		
		br.close();
	}
}