// https://www.acmicpc.net/problem/1547

#include <iostream>
using namespace std;

int arr[20];

int main() {
	int n, k, index = 0, j;
	cin >> n >> k;

	for(int i = 0; i < n; i++) {
		char c = 0;

		if(i == n - 1) {
			cin >> arr[i];
			break;
		}

		cin >> arr[i] >> c;
	}

	for(int i = 0; i < k; i++) {
		for(j = 0; j < n-i-1; j++)
			arr[j] = arr[j+1] - arr[j];
	}

	for(int i = 0; i < n-k-1; i++) {
		cout << arr[i] << ",";
	}

	cout << arr[n-k-1] << "\n";

	return 0;
}