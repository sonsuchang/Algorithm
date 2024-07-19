import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().split())
default_list = []
for i in range(1, N + 1):
    default_list.append(i)

for i in list(combinations(default_list, M)):
    print(*i)