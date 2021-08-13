package Programmers.Practice.Level2;

import java.util.ArrayList;
import java.util.List;

// 삼각 달팽이
// https://programmers.co.kr/learn/courses/30/lessons/68645
public class Problem_68645 {
	
	public static void main(String[] args) {
		int n = 6;
		int[] result = solution(n);
		
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static int[] solution(int n) {
		List<Integer> list = new ArrayList<>();
		int[][] field = new int[n][n];
		int index = 1;
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < n; i += 3) {
			for (int j = 0; j < n - i; j++) {
				field[x++][y] = index++;
			}
			
			x--;
			y++;
			
			for (int j = 0; j < n - i - 1; j++) {
				field[x][y++] = index++;
			}
			
			x--;
			y -= 2;
			
			for (int j = 0; j < n - i - 2; j++) {
				field[x--][y--] = index++;
			}
			
			x += 2;
			y++;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (field[i][j] != 0) {
					list.add(field[i][j]);
				}
			}
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}