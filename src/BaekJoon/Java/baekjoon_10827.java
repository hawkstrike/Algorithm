package BaekJoon.Java;
// https://www.acmicpc.net/problem/10827

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_10827 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		BigDecimal bd = new BigDecimal(st.nextToken());

		System.out.println(bd.pow(Integer.parseInt(st.nextToken())).toPlainString());

		sc.close();
	}
}