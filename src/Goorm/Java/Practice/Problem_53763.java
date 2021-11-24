package Goorm.Java.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_53763 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(n -> Integer.parseInt(n))
				.distinct()
				.sorted()
				.toArray();
		
		System.out.println((arr.length >= 3) ? "YES" : "NO");
		
		br.close();
	}
}