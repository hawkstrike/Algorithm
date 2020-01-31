// https://www.acmicpc.net/problem/8980

#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
using namespace std;

class Box {
public :
	int start;
	int end;
	int count;

	Box(int start, int end, int count) {
		this->start = start;
		(*this).end = end;
		this->count = count;
	}
};

int truck[2001];
vector<Box> v;

int cmp(Box b1, Box b2) {
	return b1.start > b2.start || (b1.start == b2.start && b1.end < b2.end);
}

int main() {
	int n, c, m, x, y, count;
	int sum = 0, result = 0;

	cin >> n >> c >> m;

	for(int i = 0; i < m; i++) {
		cin >> x >> y >> count;
		v.push_back(*new Box(x, y, count));
	}

	sort(v.begin(), v.end(), cmp);

	for(int i = 0; i < m; i++) {
		int check = 0;
		Box b = v.at(i);

		for(int j = b.start; j < b.end; j++)
			if(truck[j] > check)
				check = truck[j];

		sum = min(b.count, c - check);

		for(int j = b.start; j < b.end; j++)
			truck[j] += sum;

		result += sum;
	}

	cout << result << "\n";

	return 0;
}