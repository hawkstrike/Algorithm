package BaekJoon.java;
// https://www.acmicpc.net/problem/1181

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class baekjoon_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] s = new String[n];

		for(int i = 0; i < s.length; i++)
			s[i] = sc.nextLine();

		Arrays.sort(s, 0, s.length, new Comparator<String>() {

			public int compare(String s1, String s2) {
				if(s1.length() == s2.length())
					return s1.compareTo(s2);
				else if(s1.length() > s2.length())
					return 1;
				else
					return -1;
			}
		});

		String str;
		boolean b;

		for(int i = 0; i < s.length; i++) {
			str = s[i];
			b = true;
			for(int j = i + 1; j < s.length; j++){
				if(str.equals(s[j])) {
					b = false;
					break;
				}
			}
			if(b)
				System.out.println(s[i]);
		}

		sc.close();
	}
}