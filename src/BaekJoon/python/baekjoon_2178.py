# https://www.acmicpc.net/problem/2178

import sys
readLine = lambda : sys.stdin.readline().strip()
n, m = map(int, readLine().split())

field = [[int(row) for row in readLine()] for col in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs() :
	field[0][0] = 2
	q = []
	q.append((0, 0, 1))

	while(len(q)) :
		coor = q.pop(0)

		if n-1 == coor[0] and m-1 == coor[1] :
			print(coor[2])
			break

		for i in range(4) :
			currX, currY, count = coor
			currX += dx[i]
			currY += dy[i]

			if (currX >= 0 and currY >= 0 and currX < n and currY < m) and (field[currX][currY] is 1) :
				field[currX][currY] = 2
				count += 1
				q.append((currX, currY, count))

bfs()