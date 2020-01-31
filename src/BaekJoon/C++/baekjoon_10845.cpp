// https://www.acmicpc.net/problem/10845

#include <iostream>
#include <string>
using namespace std;

class queue {
private :
	class queueNode {
		friend class queue;
		int element;
		queueNode *next;
		queueNode(int element, queueNode *next) {
			this->element = element;
			(*this).next = next;
		}
	};
	queueNode *frontQueue;
	queueNode *rearQueue;
	int queueSize;

public :
	queue() {
		frontQueue = NULL;
		rearQueue = NULL;
		queueSize = 0;
	}
	void push(int x);
	int pop();
	int size();
	int empty();
	int front();
	int back();
};

void queue::push(int x) {
	queueSize++;
	queueNode *pushNode = new queueNode(x, NULL);
	if(frontQueue == NULL)
		frontQueue = pushNode;
	else
		rearQueue->next = pushNode;
	rearQueue = pushNode;
}
int queue::pop() {
	if(frontQueue == NULL)
		return -1;
	else {
		queueSize--;
		int temp = frontQueue->element;
		frontQueue = frontQueue->next;
		if(empty())
			rearQueue = NULL;
		return temp;
	}
}
int queue::size() {
	return queueSize;
}
int queue::empty() {
	if(queueSize == 0)
		return 1;
	else
		return 0;
}
int queue::front() {
	if(frontQueue == NULL)
		return -1;
	else
		return frontQueue->element;
}
int queue::back() {
	if(rearQueue == NULL)
		return -1;
	else
		return rearQueue->element;
}

int main() {
	queue q;
	int n;

	cin >> n;

	for(int i = 0; i < n; i++) {
		string str;
		cin >> str;

		if(str == "push") {
			int x;
			cin >> x;
			q.push(x);
		} else if(str == "pop") {
			cout << q.pop() << "\n";
		} else if(str == "size") {
			cout << q.size() << "\n";
		} else if(str == "empty") {
			cout << q.empty() << "\n";
		} else if(str == "front") {
			cout << q.front() << "\n";
		} else if(str == "back") {
			cout << q.back() << "\n";
		}

	} // end of for
	return 0;
}