package BaekJoon.Java;
// https://www.acmicpc.net/problem/10809

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] arr = new int[26];

		Arrays.fill(arr, -1);

		for(int i = 0; i < str.length(); i++) {
			if(arr[str.charAt(i)-97] == -1)
				arr[str.charAt(i)-97] = i;
		}

		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		sc.close();
	}
}