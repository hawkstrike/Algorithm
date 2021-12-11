package RSQUARE.CodingTest.Challenge1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int a = 1; a < length; a++) {
			for (int b = a; b < length; b++) {
				int c = length - (a + b);
				
				if (c < 0 || c < b) {
					break;
				}
				
				if (a + b > c) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		br.close();
	}
}