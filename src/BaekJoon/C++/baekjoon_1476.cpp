// https://www.acmicpc.net/problem/1416

#include <iostream>
using namespace std;

int main() {
	int e, s, m, cnt = 1, e1 = 1, s1 = 1, m1 = 1;
	cin >> e >> s >> m;

	while(1) {
		if(e == e1 && s == s1 && m == m1)
			break;
		e1++;
		s1++;
		m1++;
		if(e1 > 15)
			e1 = 1;
		if(s1 > 28)
			s1 = 1;
		if(m1 > 19)
			m1 = 1;
		cnt++;
	}

	cout << cnt << "\n";

	return 0;
}