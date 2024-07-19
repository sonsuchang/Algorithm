import sys
N, M = map(int, sys.stdin.readline().split())
N_set = set()
M_set = set()
for _ in range(N):
    N_set.add(input())
for _ in range(M):
    M_set.add(input())
result_list = sorted(list(N_set & M_set))
print(len(result_list))
for i in result_list:
    print(i)