// https://www.acmicpc.net/problem/1546

#include <iostream>
using namespace std;

double score[1000];

int main() {
	int n;
	cin >> n;

	double avg = 0.0, max = 0.0;

	for(int i = 0; i < n; i++) {
		cin >> score[i];
		if(score[i] > max)
			max = score[i];
	}

	for(int i = 0; i < n; i++) {
		score[i] = (double)(score[i] / max) * 100.0;
		avg += score[i];
	}

	avg /= n;
	printf("%.2f\n", avg);

	return 0;
}