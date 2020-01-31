// https://www.acmicpc.net/problem/2146

#include <iostream>
#include <vector>
using namespace std;

class coordinate {
public :
	int x, y;
	coordinate() {
	}
	coordinate(int x, int y) {
		this->x = x;
		(*this).y = y;
	}
};

int field[100][100];
bool visited[100][100];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int n, minLength = 10000;

void bfs(int x, int y, int number) {
	vector<coordinate> v;
	coordinate c;

	v.push_back(*new coordinate(x, y));
	visited[x][y] = 1;

	field[x][y] = number;

	while(!v.empty()) {
		c = *v.begin();
		v.erase(v.begin());
		for(int i = 0; i < 4; i++) {
			int currX = c.x + dx[i];
			int currY = c.y + dy[i];
			if(currX >= 0 && currY >= 0 && currX < n && currY < n) {
				if(field[currX][currY] == 1 && visited[currX][currY] == 0) {
					field[currX][currY] = number;
					v.push_back(*new coordinate(currX, currY));
					visited[currX][currY] = 1;
				}
			}
		}
	}
}

int main() {
	int number = 1;
	cin >> n;

	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			cin >> field[i][j];

	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			if(field[i][j] == 1 && visited[i][j] == 0) {
				bfs(i, j, number);
				number++;
			}
		}
	}

	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			if(field[i][j])
				for(int x = 0; x < n; x++)
					for(int y = 0; y < n; y++)
						if(field[x][y])
							if(field[i][j] != field[x][y])
								minLength = min(abs(x-i) + abs(y-j) - 1, minLength);

	cout << minLength << "\n";

	return 0;
}