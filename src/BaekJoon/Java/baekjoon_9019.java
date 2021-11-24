package BaekJoon.Java;
// https://www.acmicpc.net/problem/9019

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_9019 {
	static int start, end;

	public static class pair {
		int n;
		long o;

		public pair(int n, long o) {
			this.n = n;
			this.o = o;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			bfs();
		}
		
		sc.close();
	}

	public static void bfs() {
		Queue<pair> q = new LinkedList<pair>();
		boolean[] v = new boolean[10000];
		String str = "";
		long here = 0;
		q.add(new pair(start, 0));

		while(!q.isEmpty()) {
			pair p = q.poll();

			if(p.n == end) {
				here = p.o;
				break;
			}

			int temp = 2 * p.n % 10000;

			if(!v[temp]) {
				q.add(new pair(temp, p.o * 10 + 1));
				v[temp] = true;
			}

			temp = p.n - 1;

			if(temp == -1)
				temp = 9999;

			if(!v[temp]) {
				q.add(new pair(temp, p.o * 10 + 2));
				v[temp] = true;
			}

			temp = (p.n % 1000) * 10 + p.n / 1000;

			if(!v[temp]) {
				q.add(new pair(temp, p.o * 10 + 3));
				v[temp] = true;
			}

			temp = (p.n % 10) * 1000 + p.n / 10;

			if(!v[temp]) {
				q.add(new pair(temp, p.o * 10 + 4));
				v[temp] = true;
			}

		}

		while(here > 0) {
			long order = here % 10;
			here /= 10;
			str += (order == 1) ? "D" : (order == 2) ? "S" : (order == 3) ? "L" : "R";
		}

		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb.reverse().toString());
	}
}