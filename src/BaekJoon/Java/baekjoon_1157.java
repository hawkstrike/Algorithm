package BaekJoon.Java;
// https://www.acmicpc.net/problem/1157

import java.util.Scanner;

public class baekjoon_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().toUpperCase();
		int[] arr = new int[26];

		for(int i = 0; i < s.length(); i++)
			arr[s.charAt(i)-65]++;

		int max = 0;
		int c = 0;

		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				c = i + 65;
			}
			else if(max == arr[i])
				c = '?';
		}
		System.out.println((char)c);
		sc.close();
	}
}