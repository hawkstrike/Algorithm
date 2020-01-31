// https://www.acmicpc.net/problem/1697

#include <iostream>
#include <queue>
using namespace std;

bool visited[100001];

int main() {
	int n, k;
	int dist[3] = {-1, 1, 2};
	cin >> n >> k;

	queue<pair<int,int>> q;
	q.push(make_pair(n, 0));
	visited[n] = 1;

	while(!q.empty()) {
		int location = q.front().first;
		int count = q.front().second;

		if(location == k) {
			cout << count << "\n";
			return 0;
		}

		q.pop();

		for(int i = 0; i < 3; i++) {
			int currX = (i != 2) ? location + dist[i] : location * dist[i];

			if(currX >= 0 && currX <= 100000) {
				if(visited[currX] == 0) {
					q.push(make_pair(currX, count+1));
					visited[currX] = 1;
				}
			}
		}
	}

	return 0;
}