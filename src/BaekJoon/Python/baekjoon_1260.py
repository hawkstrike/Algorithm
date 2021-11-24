# https://www.acmicpc.net/problem/1260

import sys
readLine = lambda : sys.stdin.readline().strip()
n, m, v = map(int, readLine().split())

g = [[] for i in range(n+1)]
visited = [False] * (n+1)

for i in range(m) :
	x, y = map(int, readLine().split())
	g[x].append(y)
	g[y].append(x)

for i in range(n+1) :
	g[i].sort()

result = []

def dfs(g, start) :
	result.append(start)
	visited[start] = True

	for i in g[start] :
		if visited[i] != True :
			dfs(g, i)

def bfs(g, start) :
	result.append(start)
	visited[start] = True
	print(start, end=" ")

	while(len(result)) :
		curr = result.pop(0)

		for i in g[curr] :
			if visited[i] == False :
				visited[i] = True
				result.append(i)
				print(i, end=" ")

dfs(g, v)
for i in result :
	print(i, end=" ")
print()
result = []
visited = [False] * (n+1)
bfs(g, v)