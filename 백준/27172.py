import sys

N = int(sys.stdin.readline())
N_list = [0] * 1000001
score_list = [0] * 1000001
temp = list(map(int, sys.stdin.readline().split()))
for i in temp:
    N_list[i] = 1
for i in range(1000001):
    if N_list[i] == 1:
        for j in range(i * 2, 1000001, i):
            if N_list[j] == 1:
                score_list[i] += 1
                score_list[j] -= 1
output = []
for i in temp:
    output.append(score_list[i])
print(*output)