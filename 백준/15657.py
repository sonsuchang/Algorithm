import sys
from itertools import combinations_with_replacement

N, M = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))
num_list.sort()
for i in combinations_with_replacement(num_list, M):
    print(*i)