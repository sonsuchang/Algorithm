import sys

input = sys.stdin.readline

N, M = map(int, input().split())

N_list = [i for i in range(1, N + 1)]

for _ in range(M):
    i, j, k = map(int, input().split())
    temp = N_list[k - 1 : j] + N_list[i - 1 : k - 1]
    idx = 0
    for x in range(i - 1, j):
        N_list[x] = temp[idx]
        idx += 1
print(*N_list)