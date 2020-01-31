// https://www.acmicpc.net/problem/5567

#include <iostream>
#include <vector>
using namespace std;

bool arr[501][501];
bool v[501];
vector<pair<int, int>> q;
int n, m, x, y;

void bfs() {
	int count = 0;
	v[1] = true;
	q.push_back(make_pair(1, 0));
	pair<int, int> temp;

	while(!q.empty()) {
		temp.first = q.at(0).first;
		temp.second = q.at(0).second;
		q.erase(q.begin());

		for(int i = 1; i <= n; i++) {
			if(arr[temp.first][i] == true && v[i] == false) {
				q.push_back(make_pair(i, temp.second+1));
				v[i] = true;
				if(temp.second <= 1)
					count++;
			}
		}
	}

	cout << count << "\n";
}

int main() {
	cin >> n >> m;

	for(int i = 0; i < m; i++) {
		cin >> x >> y;
		arr[x][y] = true;
		arr[y][x] = true;
	}

	bfs();

	return 0;
}