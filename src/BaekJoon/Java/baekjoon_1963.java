package BaekJoon.Java;
// https://www.acmicpc.net/problem/1963

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_1963 {
	static boolean[] arr = new boolean[10000];
	static int start, end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i = 2; i <= 1000; i++) {
			if(!arr[i]) {
				for(int j = 2 * i; j < 10000; j += i)
					arr[j] = true;
			}
		}

		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			bfs();
		}
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		int qSize = q.size();
		int cnt = 0;
		boolean flag = false;
		boolean[] v = new boolean[10000];

		while(!q.isEmpty()) {
			int minority = q.poll();

			if(minority == end) {
				System.out.println(cnt);
				flag = true;
				break;
			}

			for(int i = 0; i < 4; i++) {
				String s = Integer.toString(minority);

				for(int j = 0; j <= 9; j++) {
					if (i != 0 || j != 0) {
						StringBuilder sb = new StringBuilder(s);
						sb.setCharAt(i, (char)(j + 48));
						int temp = Integer.parseInt(sb.toString());
						if (!arr[temp] && !v[temp]) {
							q.add(temp);
							v[temp] = true;
						}
					}
				}
			}

			qSize--;
			if(qSize == 0) {
				qSize = q.size();
				cnt++;
			}
		}

		if(!flag)
			System.out.println("impossible");
	}
}