package BaekJoon.java;
// https://www.acmicpc.net/problem/10757

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		BigInteger bi = new BigInteger(st.nextToken());

		System.out.println(bi.add(new BigInteger(st.nextToken())));
		sc.close();
	}
}