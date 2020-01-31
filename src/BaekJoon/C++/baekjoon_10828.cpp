// https://www.acmicpc.net/problem/10828

#include <iostream>
#include <string>
using namespace std;

class stackNode {
public :
	int data;
	stackNode *next;

	stackNode() {
		data = 0;
		next = NULL;
	}

	stackNode(int data, stackNode *next) {
		this->data = data;
		(*this).next = next;
	}
};

class stack {
private :
	stackNode *topNode;
	int stackSize;
public :
	stack() {
		topNode = NULL;
		stackSize = 0;
	}

	void push(int);

	int pop() {
		if(empty()) {
			return -1;
		}

		int temp;

		temp = topNode->data;
		topNode = topNode->next;
		stackSize--;

		return temp;

	}

	int empty();
	int top() {
		if(empty())
			return -1;
		else
			return topNode->data;
	}

	int size();
};

void stack::push(int data) {
	topNode = new stackNode(data, topNode);
	stackSize++;
}

int stack::empty() {
	if(!topNode)
		return 1;
	else
		return 0;
}

int stack::size() {
	return stackSize;
}

int main() {
	int n;
	stack s;

	cin >> n;

	for(int i = 0; i < n; i++) {
		string str;
		cin >> str;

		if(str == "push") {
			int x;
			cin >> x;
			s.push(x);
		} else if(str == "pop") {
			cout << s.pop() << "\n";
		} else if(str == "size") {
			cout << s.size() << "\n";
		} else if(str == "empty") {
			cout << s.empty() << "\n";
		} else if(str == "top") {
			cout << s.top() << "\n";
		}
	} // end of for

	return 0;
}