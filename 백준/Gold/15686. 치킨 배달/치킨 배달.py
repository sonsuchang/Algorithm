import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().split())

board = []

for _ in range(N):
    board.append(list(map(int, sys.stdin.readline().split())))

find_two = []
find_dict = {}
answer = []

for i in range(N):
    for j in range(N):
        if board[i][j] == 1:
            find_dict[(i, j)] = 2500
        elif board[i][j] == 2:
            find_two.append((i, j))

for j in list(combinations(find_two, M)):
    # j일때 sum값들
    for x in find_dict.keys():
        find_dict[x] = 2500
    for k in j:
        for i in find_dict.keys():
            if find_dict[i] > abs(i[0] - k[0]) + abs(i[1] - k[1]):
                find_dict[i] = abs(i[0] - k[0]) + abs(i[1] - k[1])
    answer.append(sum(find_dict.values()))
print(min(answer))