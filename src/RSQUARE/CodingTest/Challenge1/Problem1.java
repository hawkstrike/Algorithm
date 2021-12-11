package RSQUARE.CodingTest.Challenge1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = 1000 - Integer.parseInt(br.readLine());
		int[] coinArr = {500, 100, 50, 10};
		int[] countArr = new int[4];
		
		for (int i = 0; i < coinArr.length; i++) {
			if (money / coinArr[i] > 0) {
				countArr[i] = money / coinArr[i];
				money -= countArr[i] * coinArr[i];
			}
		}
		
		for (int i = 0; i < countArr.length; i++) {
			System.out.print(countArr[i] + " ");
		}
		System.out.println();
		
		br.close();
	}
}