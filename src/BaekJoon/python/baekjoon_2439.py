# https://www.acmicpc.net/problem/2439

n = int(input())+1

for i in range(1, n) :
	print(" " * (n-i-1), end="")
	print("*" * i)