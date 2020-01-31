# https://www.acmicpc.net/problem/1012

import sys
from collections import deque

readLine = lambda : sys.stdin.readline().strip()
time = int(readLine())

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def bfs(field, x, y) :
	q = deque([])
	q.append((x, y))
	field[x][y] = 0

	while(len(q)) :
		coor = q.popleft()

		for i in range(4) :
			currX, currY = coor
			currX += dx[i]
			currY += dy[i]

			if currX >= 0 and currY >= 0 and currX < len(field) and currY < len(field[0]) and field[currX][currY] is 1 :
				field[currX][currY] = 0
				q.append((currX, currY))


for test_case in range(time) :
	m, n, k = map(int, readLine().split(" "))
	field = [[0 for i in range(n)] for j in range(m)]
	count = 0

	for i in range(k) :
		x, y = map(int, readLine().split(" "))
		field[x][y] = 1

	for i in range(m) :
		for j in range(n) :
			if field[i][j] is 1 :
				bfs(field, i, j)
				count += 1

	print(count)