# https://www.acmicpc.net/problem/7576

import sys
from collections import deque

readLine = lambda : sys.stdin.readline().strip()
m, n = map(int, readLine().split(" "))

field = [[int(i) for i in readLine().split(" ")] for j in range(n)]
q = deque([])
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(n) :
	for j in range(m) :
		if field[i][j] == 1 :
			q.append((i, j, 0))

def bfs() :
	max = 0

	while(len(q)) :
		coor = q.popleft()

		if coor[2] > max :
			max = coor[2]

		for i in range(4) :
			currX, currY, count = coor
			currX += dx[i]
			currY += dy[i]

			if (currX >= 0 and currY >= 0 and currX < n and currY < m) and field[currX][currY] is 0 :
				field[currX][currY] = 1
				q.append((currX, currY, count+1))

	for i in range(n) :
		for j in range(m) :
			if field[i][j] is 0 :
				print(-1)
				return

	print(max)

bfs()