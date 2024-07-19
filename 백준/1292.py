import sys

A, B = map(int, sys.stdin.readline().split())

N_list = []

for j in range(1, 1000):
    for k in range(j):
        N_list.append(j)
print(sum(N_list[:B]) - sum(N_list[:A - 1]))