# https://www.acmicpc.net/problem/9498

n = int(input())

print((n >= 90 and 'A' or (n >= 80) and 'B' or (n >= 70) and 'C' or (n >= 60) and 'D' or 'F'))