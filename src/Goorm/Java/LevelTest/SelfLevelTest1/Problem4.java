package Goorm.Java.LevelTest.SelfLevelTest1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// https://level.goorm.io/exam/49912/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%96%B4%EB%A1%9C%EC%A6%88-%EC%85%80%ED%94%84%EB%A0%88%EB%B2%A8%ED%85%8C%EC%8A%A4%ED%8A%B8-1%EC%B0%A8/quiz/4
public class Problem4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] fenceArr = Arrays.stream((br.readLine() + " 0").split(" "))
				.mapToInt(num -> Integer.parseInt(num))
				.toArray();
		Stack<Integer> stack = new Stack<>();
		int maxSquare = Integer.MIN_VALUE;
		
		for (int i = 0; i <= n; i++) {
			while (!stack.isEmpty() && fenceArr[stack.peek()] >= fenceArr[i]) {
				int index = stack.pop();
				int width = (!stack.isEmpty()) ? i - stack.peek() - 1 : i;
				
				maxSquare = Math.max(maxSquare, fenceArr[index] * width);
			}
			
			stack.push(i);
		}
		
		System.out.println(maxSquare);
		
		br.close();
	}
}