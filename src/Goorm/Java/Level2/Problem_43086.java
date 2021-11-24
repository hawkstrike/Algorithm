package Goorm.Java.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_43086 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toLowerCase().replace(" ", "").toCharArray();
		int[] countArr = new int[26];
		
		for (char c : arr) {
			 countArr[c - 'a']++;
		}
		
		for (int i = 0; i < countArr.length; i++) {
			System.out.println((char) (i + 'a') + " : " + countArr[i]);
		}
		
		br.close();
	}
}