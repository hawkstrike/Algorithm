package BaekJoon.Java;
// https://www.acmicpc.net/problem/1316

import java.util.Scanner;

public class baekjoon_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int cnt = 0;

		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			int[] arr = new int[26];
			boolean flag = false;

			for(int j = 0; j < s.length() - 1; j++) {
				if(s.charAt(j) == s.charAt(j+1))
					continue;
				else {
					int index = s.charAt(j) - 97;

					if (arr[index] == 0) {
						arr[index]++;
					} else {
						flag = true;
					}
				}
			}
			if(!flag)
				if(arr[s.charAt(s.length()-1)-97] == 0)
					cnt++;
		}

		System.out.println(cnt);
	}
}