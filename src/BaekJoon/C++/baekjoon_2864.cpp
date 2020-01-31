// https://www.acmicpc.net/problem/2864

#include <iostream>
#include <string>
using namespace std;

int main() {
	string str1, str2;
	cin >> str1 >> str2;

	for(int i = 0; i < str1.length(); i++) {
		if(str1.at(i) == '6')
			str1.at(i) = '5';
	}

	for(int i = 0; i < str2.length(); i++) {
		if(str2.at(i) == '6')
			str2.at(i) = '5';
	}

	int n1, n2;
	n1 = stoi(str1);
	n2 = stoi(str2);

	cout << n1 + n2 << " ";

	for(int i = 0; i < str1.length(); i++) {
		if(str1.at(i) == '5')
			str1.at(i) = '6';
	}

	for(int i = 0; i < str2.length(); i++) {
		if(str2.at(i) == '5')
			str2.at(i) = '6';
	}

	n1 = stoi(str1);
	n2 = stoi(str2);

	cout << n1 + n2 << "\n";

	return 0;
}