# https://www.acmicpc.net/problem/2583

import sys
from collections import deque

readLine = lambda : sys.stdin.readline().strip()
m, n, k = map(int, readLine().split())
field = [[0 for i in range(n)] for j in range(m)]

for i in range(k) :
	x1, y1, x2, y2 = map(int, readLine().split())
	for row in range(y1, y2) :
		for col in range(x1, x2) :
			field[row][col] = 1

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
areaList = []

def bfs(x, y) :
	q = deque([])
	q.append((x, y))
	field[x][y] = 1
	area = 1

	while(len(q)) :
		coor = q.popleft()

		for i in range(4) :
			x, y = coor
			x += dx[i]
			y += dy[i]

			if x >= 0 and y >= 0 and x < m and y < n and field[x][y] is 0 :
				field[x][y] = 1
				q.append((x, y))
				area += 1

	areaList.append(area)

for i in range(m) :
	for j in range(n) :
		if field[i][j] is 0 :
			bfs(i, j)

areaList.sort()
print(len(areaList))
print(' '.join(str(i) for i in areaList))