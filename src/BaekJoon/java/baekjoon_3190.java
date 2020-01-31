package BaekJoon.java;
// https://www.acmicpc.net/problem/3190

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_3190 {
	public static class coordinate {
		int x;
		int y;

		coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class direct {
		int move;
		char direction;

		direct(int move, char direction) {
			this.move = move;
			this.direction = direction;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<coordinate> list = new LinkedList<coordinate>();
		Queue<direct> q = new LinkedList<direct>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int count = 0;

		int n = sc.nextInt(); //
		int[][] field = new int[n+2][n+2];
		int k = sc.nextInt(); // 사과 개수

		for(int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			field[x][y] = 3; // 사과는 3이다!
		}

		int l = sc.nextInt();
		int head = 1; // 0 - north, 1 - east, 2 - south, 3 - west

		list.add(new coordinate(1, 1));
		field[1][1] = 1;

		for(int i = 0; i < l; i++) {
			int move = sc.nextInt();
			char direction = sc.next().charAt(0);
			q.add(new direct(move, direction));
		}

		direct d = null;
		int m = 0;

		while(true) {
			if(m <= 0 && !q.isEmpty()) {
				d = q.poll();
				m = d.move - count;
			}

			coordinate c = list.get(list.size()-1);
			int currX = c.x + dx[head];
			int currY = c.y + dy[head];

			if(currX >= 0 && currY >= 0 && currX < field.length && currY < field.length) {
				count++;
				if((currX == 0 || currY == 0 || currX == field.length-1 || currY == field.length-1) || field[currX][currY] == 1)
					break;

				if(field[currX][currY] != 3) {
					coordinate r = list.remove(0);
					field[r.x][r.y] = 0;
				}

				field[currX][currY] = 1;
				list.add(new coordinate(currX, currY));
			} // end of if
			else {
				count++;
				break;
			}

			m--;

			if(m <= 0 && d.direction != 'A') {
				if (d.direction == 'L') { // 왼쪽
					if (head == 0)
						head = 3;
					else
						head--;
				} else if (d.direction == 'D') { // 오른쪽
					if (head == 3)
						head = 0;
					else
						head++;
				}

				d.direction = 'A';
			}
		} // end of while

		System.out.println(count);
		sc.close();
	}
}