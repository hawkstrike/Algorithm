package BaekJoon.Java;
// https://www.acmicpc.net/problem/9012

import java.util.Scanner;
import java.util.Stack;

public class baekjoon_9012 {
	public static void main(String[] args) {
		Stack<Character> stack;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			stack = new Stack<Character>();

			for(int j = 0; j < s.length(); j++) {
				if(stack.isEmpty()) {
					stack.push(s.charAt(j));
				} else {
					if(s.charAt(j) == '(')
						stack.push(s.charAt(j));
					else if(s.charAt(j) == ')' && stack.peek() == '(')
						stack.pop();
				}
			}

			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}

		sc.close();
	}
}