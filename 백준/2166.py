import sys

N = int(sys.stdin.readline())
N_list = []
for _ in range(N):
    N_list.append(list(map(int, sys.stdin.readline().split())))
N_list.append(N_list[0])
sum_a = 0
sum_b = 0
for i in range(N):
    sum_a += N_list[i][0] * N_list[i + 1][1]
    sum_b += N_list[i][1] * N_list[i + 1][0]
print(round(abs(sum_b - sum_a) / 2, 2))