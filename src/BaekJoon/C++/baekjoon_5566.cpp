// https://www.acmicpc.net/problem/5566

#include <iostream>
using namespace std;

int arr[1001];

int main() {
	int n, m, toss, here = 1;
	cin >> n >> m;

	for(int i = 1; i <= n; i++)
		cin >> arr[i];

	for(int i = 1; i <= m; i++) {
		cin >> toss;
		here += toss;

		if(here >= n) {
			cout << i << "\n";
			break;
		}

		here += arr[here];

		if(here >= n) {
			cout << i << "\n";
			break;
		}
	}

	return 0;
}