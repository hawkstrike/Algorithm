// https://www.acmicpc.net/problem/11047

#include <iostream>
using namespace std;

int n, k;
int arr[11];

int main() {
	int count = 0;
	cin >> n >> k;

	for(int i = 1; i <= n; i++)
		cin >> arr[i];

	while(k > 0) {
		if(arr[n] <= k) {
			count += k / arr[n];
			k %= arr[n];
		}

		n--;
	}

	cout << count << "\n";
	return 0;
}