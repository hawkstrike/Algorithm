package BaekJoon.Java;
// https://www.acmicpc.net/problem/10828

import java.util.Scanner;

class Stack_Node {

	Stack_Node next;
	int data;

	Stack_Node() {
		next = null;
		data = 0;
	}

	Stack_Node(int element) {
		this.data = element;
	}

	Stack_Node(int element, Stack_Node next) {
		this.data = element;
		this.next = next;
	}
}

class Stack {
	protected Stack_Node top;
	protected int size = 0;

	Stack() {
		top = null;
	}

	void push(int x) {
		size++;
		top = new Stack_Node(x, top);
	}

	int pop() {
		if(size == 0)
			return -1;

		size--;

		int element = top.data;
		top = top.next;

		return element;
	}

	int empty() {
		if(size == 0)
			return 1;

		return 0;
	}

	int top() {
		if(size == 0)
			return -1;

		return top.data;
	}
}

public class baekjoon_10828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack stack = new Stack();

		for(int test_case = 1; test_case <= n; test_case++) {
			String s = sc.next();

			if(s.equals("push")) {
				int x = sc.nextInt();

				stack.push(x);
			} else if(s.equals("pop"))
				System.out.println(stack.pop());
			else if(s.equals("size"))
				System.out.println(stack.size);
			else if(s.equals("empty"))
				System.out.println(stack.empty());
			else if(s.equals("top"))
				System.out.println(stack.top());
		}

		sc.close();
	}
}