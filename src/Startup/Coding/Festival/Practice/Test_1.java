package Startup.Coding.Festival.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstInputArr = br.readLine().split(" ");
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(firstInputArr[0]); // 수열의 길이
		int k = Integer.parseInt(firstInputArr[1]); // 연속으로 골라야 하는 정수의 개수
		
		int result = ((n - 1) % (k - 1) == 0) ? (n - 1) / (k - 1) : (n - 1) / (k - 1) + 1;
		
		System.out.println(result);
	}
}