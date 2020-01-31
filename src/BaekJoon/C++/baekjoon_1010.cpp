// https://www.acmicpc.net/problem/1010

#include <iostream>
using namespace std;

int main() {
	int arr[31][31];

	for(int i = 1; i < 31; i++)
		arr[i][1] = i;

	for(int i = 2; i < 31; i++) {
		for(int j = 2; j < 31; j++) {
			if(i == j)
				arr[i][j] = 1;
			else
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
		}
	}
	int T, n, m;
	cin >> T;

	for(int i = 0; i < T; i++) {
		cin >> n >> m;
		cout << arr[m][n] << "\n";
	}
}