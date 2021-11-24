package BaekJoon.Java;
// https://www.acmicpc.net/problem/1759

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_1759 {
	static int L, C;
	static char[] arr;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new char[C];
		v = new boolean[C];
		sc.nextLine();

		String s = sc.nextLine();
		int cnt = 0;
		for(int i = 0; i < s.length(); i++)
			if(s.charAt(i) != ' ')
				arr[cnt++] = s.charAt(i);

		Arrays.sort(arr);
		dfs("", 0);

		System.out.println(sb.toString());
		sc.close();
	}

	public static void dfs(String str, int cnt) {
		if(str.length() == L) {
			if(check(str))
				sb.append(str + "\n");
			return;
		}

		if(cnt >= arr.length)
			return;

		dfs(str + arr[cnt], cnt + 1);
		dfs(str, cnt + 1);
	}

	public static boolean check(String str) {
		int ja = 0, mo = 0;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o')
				mo++;
			else
				ja++;
		}

		return mo > 0 && ja > 1;
	}
}