// https://www.acmicpc.net/problem/8741

#include <iostream>
using namespace std;

int main() {
	int k, sum = 0;
	cin >> k;

	for(int i = 0; i < k; i++)
		cout << "1";

	for(int i = 0; i < k-1; i++)
		cout << "0";

	cout << "\n";

	return 0;
}