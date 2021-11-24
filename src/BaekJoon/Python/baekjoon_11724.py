# https://www.acmicpc.net/problem/11724

import sys
from collections import deque

readLine = lambda : sys.stdin.readline().strip()
n, m = map(int, readLine().split())
field = [[0 for i in range(n)] for j in range(n)]
v = [False for i in range(n)]

def bfs(start) :
	q = deque([])
	q.append(start)
	v[start] = True

	while(len(q)) :
		vector = q.popleft()

		for i in range(n) :
			if field[vector][i] is 1 and v[i] is False :
				v[i] = True
				q.append(i)


for i in range(m) :
	x, y = map(int, readLine().split())
	field[x-1][y-1] = 1
	field[y-1][x-1] = 1

for i in range(n) :
	field[i][i] = 1

count = 0

for i in range(n) :
	for j in range(n) :
		if field[i][j] is 1 and v[i] is False :
			bfs(i)
			count += 1

print(count)