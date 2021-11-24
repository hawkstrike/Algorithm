package BaekJoon.Java;
// https://www.acmicpc.net/problem/2003

import java.util.Scanner;

public class baekjoon_2003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int left = 0, right = 0, cnt = 0;

		while(right < n) {
			int sum = 0;

			for(int i = left; i <= right; i++)
				sum += arr[i];

			if(sum == m)
				cnt++;

			if(left == right)
				right++;
			else if(sum <= m)
				right++;
			else if(sum > m && left < right)
				left++;
		}

		System.out.println(cnt);
		sc.close();
	}
}