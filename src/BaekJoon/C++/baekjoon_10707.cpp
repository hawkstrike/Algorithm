// https://www.acmicpc.net/problem/10707

#include <iostream>
using namespace std;

int main() {
	int xPer, yBasic, yLimit, yPer, amount, taxX = 0, taxY = 0;
	cin >> xPer >> yBasic >> yLimit >> yPer >> amount;

	taxX = xPer * amount;

	if(yLimit > amount)
		taxY = yBasic;
	else
		taxY = yBasic + ((amount - yLimit) * yPer);

	cout << ((taxX > taxY) ? taxY : taxX) << "\n";

	return 0;
}