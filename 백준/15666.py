import sys
from itertools import combinations_with_replacement

N, M = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))
num_list.sort()
output = list(set(combinations_with_replacement(num_list, M)))
output = sorted(output, key = lambda x : x)
for i in output:
    print(*i)