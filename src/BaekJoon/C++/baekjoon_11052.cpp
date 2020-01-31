// https://www.acmicpc.net/problem/11052

#include <iostream>
using namespace std;

int dp[1001];
int arr[1001];

int main() {
	int n, i, j;
	cin >> n;

	for(i = 1; i <= n; i++) {
		cin >> arr[i];

		for(j = 0; j <= i; j++)
			dp[i] = max(dp[i], dp[j] + arr[i-j]);
	}

	cout << dp[n] << "\n";

	return 0;
}