package Startup.Coding.Festival.First;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String path = br.readLine();
		char[] pathArr = path.toCharArray();
		int count = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(0);
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			if (curr == n - 1) {
				count++;
			} else {
				if (curr + 1 < n && pathArr[curr + 1] == '1') {
					queue.offer(curr + 1);
				}
				if (curr + 2 < n && pathArr[curr + 2] == '1') {
					queue.offer(curr + 2);
				}
			}
		}
		
		System.out.println(count);
	}
}