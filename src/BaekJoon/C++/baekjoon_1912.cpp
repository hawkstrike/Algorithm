// https://www.acmicpc.net/problem/1912

#include <iostream>
using namespace std;

int dp[100001];

int main() {
	int n, max = -1001;
	cin >> n;

	for(int i = 1; i <= n; i++) {
		cin >> dp[i];
		if(dp[i-1] + dp[i] > dp[i])
			dp[i] = dp[i-1] + dp[i];
		if(max < dp[i])
			max = dp[i];
	}

	cout << max << "\n";

	return 0;
}