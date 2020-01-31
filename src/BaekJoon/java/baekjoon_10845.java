package BaekJoon.java;
// https://www.acmicpc.net/problem/10845

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.StringTokenizer;

class Queue_Node {
	Queue_Node next;
	int data;

	Queue_Node() {
	}

	Queue_Node(int element) {
		this.data = element;
	}

	Queue_Node(int element, Queue_Node next) {
		this.data = element;
		this.next = next;
	}
}

class Queue {
	Queue_Node front;
	Queue_Node rear;
	int size = 0;

	Queue() {
		front = rear = null;
	}

	void push(int x){
		size++;
		Queue_Node p = new Queue_Node(x, null);

		if(front == null)
			front = p;
		else
			rear.next = p;
		rear = p;
	}

	int pop() {
		if(front == null)
			return -1;
		else {
			size--;
			int data = front.data;
			front = front.next;
			if (empty() == 1)
				rear = null;
			return data;
		}
	}

	int empty() {
		if(front == null)
			return 1;
		else
			return 0;
	}

	int front() {
		if(front == null)
			return -1;
		return front.data;
	}

	int rear() {
		if(rear == null)
			return -1;
		return rear.data;
	}
}

public class baekjoon_10845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue queue = new Queue();

		for(int test_case = 1; test_case <= n; test_case++) {
			String s = sc.next();

			if(s.equals("push")) {
				int x = sc.nextInt();
				queue.push(x);
			} else if(s.equals("pop"))
				System.out.println(queue.pop());
			else if(s.equals("size"))
				System.out.println(queue.size);
			else if(s.equals("empty"))
				System.out.println(queue.empty());
			else if(s.equals("front"))
				System.out.println(queue.front());
			else if(s.equals("back"))
				System.out.println(queue.rear());
		}

		sc.close();
	}
}