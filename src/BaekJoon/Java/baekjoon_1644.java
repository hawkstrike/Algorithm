package BaekJoon.Java;
// https://www.acmicpc.net/problem/1644

import java.util.Scanner;

public class baekjoon_1644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+2];

		for(int i = 2; i <= n; i++) {
			for(int j = 2 * i; j <= n; j += i)
				arr[j] = 1;
		}

		int left = 2, right = 2, sum = 2, cnt = 0;

		while(left <= right && right <= n) {
			if(sum == n) {
				cnt++;
				right++;
				while(arr[right] != 0)
					right++;
				sum += right;
			}
			else if(sum < n) {
				right++;
				while(arr[right] != 0)
					right++;
				sum += right;
			}
			else if(sum > n) {
				sum -= left;
				left++;
				while(arr[left] != 0)
					left++;
			}
		}

		System.out.println(cnt);
		sc.close();
	}
}