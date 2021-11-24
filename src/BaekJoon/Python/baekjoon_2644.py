# https://www.acmicpc.net/problem/2644

import sys
from collections import deque

readLine = lambda : sys.stdin.readline().strip()
n = int(readLine())
a, b = map(int, readLine().split())
m = int(readLine())
field = [[0 for i in range(n)] for j in range(n)]
v = [False for i in range(n)]

def bfs(start) :
	q = deque([])
	q.append((start, 0))
	v[start] = True

	while(len(q)) :
		curr, count = q.popleft()

		if curr is b-1 :
			print(count)
			return

		for i in range(n) :
			if field[curr][i] is 1 and v[i] is False :
				v[i] = True
				q.append((i, count+1))

	print(-1)

for i in range(m) :
	x, y = map(int, readLine().split())
	field[x-1][y-1] = 1
	field[y-1][x-1] = 1

bfs(a-1)