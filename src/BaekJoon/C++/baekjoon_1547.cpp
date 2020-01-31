// https://www.acmicpc.net/problem/1547

#include <iostream>
using namespace std;

int arr[4];

int main() {
	int m, x, y;
	cin >> m;
	arr[1] = 1;

	for(int i = 0; i < m; i++) {
		cin >> x >> y;
		int temp = arr[y];
		arr[y] = arr[x];
		arr[x] = temp;
	}

	for(int i = 0; i < 4; i++) {
		if(arr[i] == 1) {
			cout << i << "\n";
			return 0;
		}
	}

	cout << "-1\n";

	return 0;
}