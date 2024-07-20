import sys

input = sys.stdin.readline

N, M = map(int, input().split())

N_list = [i for i in range(1, N + 1)]

for _ in range(M):
    i, j = map(int, input().split())
    temp = N_list[i - 1]
    N_list[i - 1] = N_list[j - 1]
    N_list[j - 1] = temp
print(*N_list)