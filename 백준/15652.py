import sys
from itertools import combinations_with_replacement

N, M = map(int, sys.stdin.readline().split())
default_list = []
for i in range(1, N + 1):
    default_list.append(i)

for i in list(combinations_with_replacement(default_list, M)):
    print(*i)