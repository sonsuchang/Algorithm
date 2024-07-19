import sys
from itertools import permutations

N, M = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))
num_list.sort()
output = list(set(list(permutations(num_list, M))))
output = sorted(output, key = lambda x : x)
for i in output:
    print(*i)