package RSQUARE.CodingTest.Challenge1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = 3;
		int[][] squareArr = new int[length][length];
		
		for (int i = 0; i < length; i++) {
			squareArr[i] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(n -> Integer.parseInt(n))
					.toArray();
		}
		
		int x = squareArr[length - 1][0];
		int y = squareArr[length - 1][1];
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < length - 1; i++) {
			min = Math.min(Math.abs(x - squareArr[i][0]), min);
			min = Math.min(Math.abs(y - squareArr[i][1]), min);
		}
		
		System.out.println(min);
		
		br.close();
	}
}