// https://www.acmicpc.net/problem/1063

#include <iostream>
using namespace std;

char king[3], stone[3], direction[3];
int n, x, y;

int main() {
	cin >> king >> stone >> n;
	while(n > 0) {
		n--;
		cin >> direction;
		x = 0, y = 0;

		if(direction[0] == 'L') {
			x--;
			if(direction[1] == 'T') {
				y++;
			}
			else if(direction[1] == 'B') {
				y--;
			}
		} else if(direction[0] == 'R') {
			x++;
			if(direction[1] == 'T') {
				y++;
			}
			else if(direction[1] == 'B') {
				y--;
			}
		} else if(direction[0] == 'T') {
			y++;
		} else if(direction[0] == 'B') {
			y--;
		}
		if(king[0]+x >= 'A' && king[1]+y >= '1' && king[0]+x <= 'H' && king[1]+y <= '8') {
			king[0] += x;
			king[1] += y;
			if(king[0] == stone[0] && king[1] == stone[1]) {
				if(stone[0]+x >= 'A' && stone[1]+y >= '1' && stone[0]+x <= 'H' && stone[1]+y <= '8') {
					stone[0] += x;
					stone[1] += y;
				} else {
					king[0] -= x;
					king[1] -= y;
				}
			}
		}
	}
	cout << king << "\n";
	cout << stone << "\n";
	return 0;
}