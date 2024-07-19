import sys
from itertools import permutations

N, M = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))
num_list.sort()
for i in permutations(num_list, M):
    print(*i)