package BaekJoon.java;
// https://www.acmicpc.net/problem/1764

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class baekjoon_1764 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		String[] str1 = new String[n];
		String[] str2 = new String[m];
		LinkedList<String> list = new LinkedList<String>();

		sc.nextLine();

		for(int i = 0; i < n; i++)
			str1[i] = sc.nextLine();

		for(int i = 0; i < m; i++)
			str2[i] = sc.nextLine();

		Arrays.sort(str1);
		Arrays.sort(str2);

		for(int i = 0; i < n; i++) {
			int index = Arrays.binarySearch(str2, str1[i]);

			if(index >= 0) {
				cnt++;
				list.add(str2[index]);
			}
		}

		System.out.println(cnt);

		for(int i = 0; i < cnt; i++)
			System.out.println(list.get(i));

		sc.close();
	}
}