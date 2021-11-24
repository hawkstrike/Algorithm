package BaekJoon.Java;
// https://www.acmicpc.net/problem/2877

import java.util.Scanner;

public class baekjoon_2877 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int k = sc.nextInt();
		int length = k;
		k++;

		while(k > 0) {
			int n = k % 2;
			k /= 2;
			sb.append(Integer.toString(n));
		}

		sb.reverse();

		if(length >= 1)
			sb.delete(0, 1);
		else {
			sb.append("0");
			sb.delete(0, 1);
		}

		String s = new String(sb);

		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0')
				System.out.print("4");
			else if(s.charAt(i) == '1')
				System.out.print("7");
		}

		sc.close();
	}
}