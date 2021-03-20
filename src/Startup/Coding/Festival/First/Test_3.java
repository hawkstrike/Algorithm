package Startup.Coding.Festival.First;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] field = new int[n][n];
		int[] resultArr = new int[n];
		int totalCount = 0;
		
		for (int i = 0; i < n; i++) {
			String inputLine = br.readLine();
			
			for (int j = 0; j < inputLine.length(); j++) {
				field[i][j] = inputLine.charAt(j) - 48;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			checkProduct(field, resultArr, n, i, 0);
		}
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < resultArr.length; i++) {
			totalCount += resultArr[i];
			
			if (resultArr[i] > 0) {
				sb.append("size[").append((i + 1)).append("]: ").append(resultArr[i]).append("\n");
			}
		}
		
		sb.insert(0, "total: " + totalCount + "\n");
		
		System.out.println(sb.toString());
	}
	
	public static void checkProduct(int[][] field, int[] resultArr, int n, int size, int index) {
		int length = size + index;
		
		if (index >= n || length >= n) {
			return;
		}
		
		System.out.println("size : " + size + " | length : " + length + " | index : " + index);
		
		boolean flag = false;
		
		for (int i = index; i < length; i++) {
			for (int j = index; j < length; j++) {
				if (field[i][j] == 0) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				break;
			}
		}
		
		if (!flag) {
			resultArr[size - 1]++;
		}
		
		checkProduct(field, resultArr, n, size, index + 1);
	}
}