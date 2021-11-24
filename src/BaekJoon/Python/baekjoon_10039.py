# https://www.acmicpc.net/problem/10039

n = 5
arr = [0 for i in range(n)]

for i in range(n) :
	arr[i] = int(input())
	if arr[i] < 40 :
		arr[i] = 40

sum = 0
for i in range(n) :
	sum += arr[i]

print(int(sum / n))