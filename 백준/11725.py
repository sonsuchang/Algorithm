import sys
sys.setrecursionlimit(10**9)
N = int(sys.stdin.readline())

N_dict = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
output = [0] * (N + 1)

for _ in range(N - 1):
    parent, child = map(int, sys.stdin.readline().split())
    N_dict[parent].append(child)
    N_dict[child].append(parent)

def find_parent(x):
    visited[x] = True
    for i in N_dict[x]:
        if visited[i] == False:
            output[i] = x
            find_parent(i)

find_parent(1)
for i in range(2, N + 1):
    print(output[i])