package BaekJoon.java;
// https://www.acmicpc.net/problem/1260

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_1260 {
	public static void dfs(int[][] field, boolean[] c, int v) {
		Stack<Integer> s = new Stack<Integer>();
		boolean flag = false;

		c[v] = true;
		s.push(v);
		System.out.print(v + " ");

		while(!s.isEmpty()) {
			int vv = s.peek();
			flag = false;

			for(int i = 1; i < field.length; i++) {
				if(field[vv][i] == 1 && !c[i]) {
					c[i] = true;
					flag = true;
					s.push(i);
					System.out.print(i + " ");
					break;
				}
			}
			if(!flag)
				s.pop();
		}
	}

	public static void bfs(int[][] field, boolean[] c, int v) {
		Queue<Integer> q = new LinkedList<Integer>();

		c[v] = true;
		q.add(v);

		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");

			for(int i = 1; i < field.length; i++) {
				if(field[v][i] == 1 && !c[i]) {
					q.add(i);
					c[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(t.nextToken()); // 정점의 수
		int m = Integer.parseInt(t.nextToken()); // 간선의 수
		int v = Integer.parseInt(t.nextToken()); // 시작할 정점
		int[][] field = new int[n+1][n+1];
		boolean[] c = new boolean[n+1];

		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			String[] token = s.split(" ");
			field[Integer.parseInt(token[0])][Integer.parseInt(token[1])] = field[Integer.parseInt(token[1])][Integer.parseInt(token[0])] = 1;
		}

		dfs(field, c, v);
		for(int i = 0; i < c.length; i++)
			c[i] = false;
		System.out.println();
		bfs(field, c, v);
	}
}